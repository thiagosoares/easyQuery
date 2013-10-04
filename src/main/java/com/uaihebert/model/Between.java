/*
 * Copyright 2013 uaiHebert Solucoes em Informatica
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.uaihebert.model;

public class Between {
    private final String attributeName;
    private final Object valueA;
    private final Object valueB;
    private final boolean toLowerCase;

    public Between(String attributeName, Object valueA, Object valueB, boolean toLowerCase) {
        this.attributeName = attributeName;
        this.valueA = valueA;
        this.valueB = valueB;
        this.toLowerCase = toLowerCase;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Object getValueA() {
        return valueA;
    }

    public Object getValueB() {
        return valueB;
    }

    public boolean isToLowerCase() {
        return toLowerCase;
    }
}