/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package edu.iis.mto.testreactor.reservation;

import java.util.Objects;

public class ClientData {

    private Id id;

    private String name;

    public ClientData(Id id, String name) {
        this.id = id;
        this.name = name;
    }

    public Id getAggregateId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ClientData) {
            ClientData that = (ClientData) object;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }

}