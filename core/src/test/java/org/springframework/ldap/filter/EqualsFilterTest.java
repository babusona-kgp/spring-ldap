/*
 * Copyright 2005-2013 the original author or authors.
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
 */

package org.springframework.ldap.filter;

import com.gargoylesoftware.base.testing.EqualsTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Adam Skogman
 */
public class EqualsFilterTest {

    @Test
    public void testEncode() {

        EqualsFilter eqq = new EqualsFilter("foo", "*bar(fie)");

        StringBuffer buff = new StringBuffer();
        eqq.encode(buff);

        assertEquals("(foo=\\2abar\\28fie\\29)", buff.toString());

    }

    @Test
    public void testEncodeInt() {

        EqualsFilter eqq = new EqualsFilter("foo", 456);

        StringBuffer buff = new StringBuffer();
        eqq.encode(buff);

        assertEquals("(foo=456)", buff.toString());

    }

    @Test
    public void testEquals() {
        EqualsFilter originalObject = new EqualsFilter("a", "b");
        EqualsFilter identicalObject = new EqualsFilter("a", "b");
        EqualsFilter differentObject = new EqualsFilter("b", "b");
        EqualsFilter subclassObject = new EqualsFilter("a", "b") {
        };

        new EqualsTester(originalObject, identicalObject, differentObject,
                subclassObject);
    }
}
