package org.topcode;

import java.io.Serializable;

/**
 * Created by sinwaj on 2018/12/22.
 */
public class User implements Serializable{
    private final  static long serialVersionUID = 1L;
    private long id;
    private String name;
    private int age;
    private short sex;
    private String location;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;

        this.location = builder.location;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.valueOf(id);
    }

    public static class Builder {
        private final long id;
        private final String name;

        private int age;
        private short sex;
        private String location;

        public Builder(long id, String name) {
            this.id = id;
            this.name = name;

        }

        public Builder Age(int age) {
            this.age = age;
            return this;
        }

        public Builder Sex(short sex) {
            this.sex = sex;
            return this;
        }

        public Builder Location(String loaction) {
            this.location = location;
            return this;

        }

        public User build() {
            return new User(this);
        }
    }
}
