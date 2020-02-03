package com.feiyang.interviewdemo.buildDemo;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:14 2019/11/13
 */

public class Book {
    private String name;
    private BigDecimal price;
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static class Builder {
        private Book book;

        public Builder() {
            book = new Book();
        }

        public Builder name(String name) {
            book.setName(name);
            return this;
        }

        public Builder price(BigDecimal price) {
            book.setPrice(price);
            return this;
        }

        public Builder publisher(String publisher) {
            book.setPublisher(publisher);
            return this;
        }

        public Book build() {
            return book;
        }

    }

}


