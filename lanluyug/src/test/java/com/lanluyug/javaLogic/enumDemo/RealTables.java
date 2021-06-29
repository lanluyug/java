package com.lanluyug.javaLogic.enumDemo;

public enum RealTables {
    APP("tb_special_app","APP专题"),
    EMAIL("tb_special_email","email专题")
    ;
    private String name;
    private String label;
    RealTables(String name, String label) {
        this.label = label;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLabel(){
        return label;
    }
}
