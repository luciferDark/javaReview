package com.ll.java.interfaceTest;

public enum CustomType {
    GOLD(1) {
        @Override
        public String getKey() {
            return "金";
        }
    },
    WOOD(2) {
        @Override
        public String getKey() {
            return "木";
        }
    },
    WATER(3) {
        @Override
        public String getKey() {
            return "水";
        }
    },
    FIRE(8) {
        @Override
        public String getKey() {
            return "火";
        }
    },
    EARTH(9){
        @Override
        public boolean isRest() {
            return true;
        }

        @Override
        public String getKey() {
            return "土";
        }
    };

    private int value = -1;
    private CustomType(int value){
        this.value = value;
    }

    public boolean isRest() {
        return false;
    }

    public int getValue() {
        return value;
    }

    public abstract String getKey();
}
