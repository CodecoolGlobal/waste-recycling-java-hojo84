package com.codecool.wasterecycling;

public class Garbage {
        protected final String name;

        public Garbage(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("Garbage{");
                sb.append("name='").append(name).append('\'');
                sb.append('}');
                return sb.toString();
        }
}
