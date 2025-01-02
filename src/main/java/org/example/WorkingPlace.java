package org.example;

import java.util.*;

public class WorkingPlace implements DB {
    Order pre_Order = null;
    Language language = new Language();

    public WorkingPlace(Language language) {
        this.language = language;
    }

    public void menu() {
        pre_Order = new Order();
        String address = Input.str(language.lan.getString("ADDRESS"));
        pre_Order.setLocation(address);
        pre_Order.setDate(new Date());
        while (true) {
            if (pre_Order.getProducts() != null) {
                pre_Order = new Order();
                pre_Order.setLocation(address);
                pre_Order.setDate(new Date());

            }
            int chosenCategory = workWithCategories(null);
            if (chosenCategory == 0) {
                deletingEveryElement();
                return;
            }
            workingWithProducts(chosenCategory);

        }
    }

    private void deletingEveryElement() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCurrentStatus().equals(Status.IN_ACTIVE)){
                orders.remove(i);
            }
        }
    }

    private void workingWithProducts(Integer categoryId) {
        for (Product product : PRODUCTS) {
            if (product.getCategoryId().equals(categoryId)) {
                System.out.println(product);
            }
        }
        int chosenId = Input.num(language.lan.getString("CHOOSING_ID"));
        if (chosenId == 0) {
            Category ota = null;
            for (Category category : DB.CATEGORIES) {
                if (category.getId().equals(categoryId)) {
                    ota = category;
                }
            }
            workingWithProducts(workWithCategories(ota.getParentId()));
        } else {
            for (Product product : PRODUCTS) {
                if (product.getId() == chosenId) {
                    Ordering(product);
                }
            }
        }
    }

    private Integer workWithCategories(Integer parentId) {
        Scanner scanner = new Scanner(System.in);
        boolean hasChild = false;
        for (Category category : DB.CATEGORIES) {
            if (Objects.equals(category.getParentId(), parentId)) {
                hasChild = true;
                System.out.println(category.getId() + ". " + category.getName());
            }
        }
        if (!hasChild) {
            return parentId;
        }
        int chosenId = Input.num(language.lan.getString("CHOOSING_ID"));
        if (chosenId == 0) {
            if (parentId==null){
                return 0;
            }
            Category otaCategory = null;
            for (Category category : DB.CATEGORIES) {
                if (category.getId().equals(parentId)) {
                    otaCategory = category;
                }
            }
            return workWithCategories(otaCategory.getParentId());
        }
        return workWithCategories(chosenId);    }

    private void Ordering(Product product) {
        Map<Product, Integer> amount = new LinkedHashMap<>();
        amount.put(product, Input.num(language.lan.getString("AMOUNT")));
        pre_Order.setProducts(amount);
        while (true) {
            System.out.println(language.lan.getString("ACCEPT"));
            switch (Input.num(language.lan.getString("CHOOSING"))) {
                case 1 -> orders.add(pre_Order);
                case 2 -> showingProduct();
                case 3 -> {
                    return;
                }
                default -> System.out.println(":(");
            }
        }
    }

    private void showingProduct() {
        while (true) {
            if (isEmptyInActive()) {
                System.out.println(language.lan.getString("ORDERING"));
                for (int i = 0; i < orders.size(); i++) {
                    if (orders.get(i).getCurrentStatus().equals(Status.IN_ACTIVE)) {
                        System.out.print(i + 4 + " ");
                        for (Map.Entry<Product, Integer> productIntegerEntry : orders.get(i).getProducts().entrySet()) {
                            System.out.println(productIntegerEntry.getKey());
                            System.out.println(productIntegerEntry.getKey().payment(productIntegerEntry.getValue()));
                        }
                    }
                }
                int chosenService = Input.num(language.lan.getString("CHOOSING")) - 4;
                if (chosenService == -3) {
                    for (int i = 0; i < orders.size(); i++) {
                        if (orders.get(i).getCurrentStatus().equals(Status.IN_ACTIVE)) {
                            orders.get(i).setCurrentStatus(Status.ACTIVE);
                        }
                    }
                } else if (chosenService == -2) {
                    for (int i = 0; i < orders.size(); i++) {
                        if (orders.get(i).getCurrentStatus().equals(Status.IN_ACTIVE)) {
                            orders.remove(i);
                        }
                    }
                } else if (chosenService == -1) {
                    return;
                } else {
                    orders.remove(chosenService);
                }
            } else {
                System.out.println(language.lan.getString("STATUS"));
                return;
            }
        }
    }

    private boolean isEmptyInActive() {
        boolean isEmpty=false;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCurrentStatus().equals(Status.IN_ACTIVE)){
                isEmpty=true;
                return isEmpty;
            }
        }
        return isEmpty;
    }

    public void orders() {
        System.out.println("======================================");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("ID:"+orders.get(i).getId());
            System.out.println(language.lan.getString("LOCATION")+orders.get(i).getLocation());
            System.out.println(language.lan.getString("DATE")+orders.get(i).getDate());
            for (Map.Entry<Product, Integer> productIntegerEntry : orders.get(i).getProducts().entrySet()) {
                System.out.println(language.lan.getString("PRODUCT")+productIntegerEntry.getKey());
                System.out.println(language.lan.getString("COST")+productIntegerEntry.getKey().payment(productIntegerEntry.getValue()));
            }
        }
    }

    public void changingLanguage() {
        language.change();
    }
}
