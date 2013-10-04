/*
 * Copyright 2012 uaiHebert Solucoes em Informatica
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.uaihebert.model.test;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = Address.FIND_ALL, query = "select a from Address a")
public class Address {

    public static final String FIND_ALL = "Address.FindAll";

    @Id
    private int id;

    private String streetName;
    private long houseNumber;
    private boolean isOld;
    private boolean isYellow;

    @Temporal(TemporalType.DATE)
    private Date buildingDate;

    public Address() {

    }

    public Address(int id, String streetName, int houseNumber, boolean isOld, boolean isYellow, Date buildingDate) {
        this.id = id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.isOld = isOld;
        this.isYellow = isYellow;
        this.buildingDate = buildingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public boolean isOld() {
        return isOld;
    }

    public void setOld(boolean isOld) {
        this.isOld = isOld;
    }

    public boolean isYellow() {
        return isYellow;
    }

    public void setYellow(boolean isYellow) {
        this.isYellow = isYellow;
    }

    public Date getBuildingDate() {
        return buildingDate;
    }

    public void setBuildingDate(Date buildingDate) {
        this.buildingDate = buildingDate;
    }

    @Override
    public int hashCode() {
        return getId() * 34;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return address.getId() == getId();
        }

        return false;
    }
}