/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nandana.examples.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.runner.RunWith;
import org.nandana.examples.list.IntegerList;
import org.nandana.examples.list.SortOrder;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.junit.Cucumber;
import cucumber.runtime.PendingException;

public class ListSortStepdefs {
    
    private IntegerList integerList;

    @Given("^a list of integers:$")
    public void a_integers_list(List<Integer> items) throws Throwable {
    	integerList = new IntegerList(10);
    	for (int item : items) {
        	integerList.add(item);
        }
    }

    @When("^I sort that list ascending")
    public void I_sort_that_list_ascending() throws Throwable {
    	integerList.sort(SortOrder.ASCENDING);
    	//throw new PendingException();
    }
    
    @When("^I sort that list descending")
    public void I_sort_that_list_descending() throws Throwable {
    	integerList.sort(SortOrder.DESCENDING);
    	//throw new PendingException();
    }
    
    @When("^I sort the list")
    public void I_sort_the_list() throws Throwable {
    	integerList.sort(SortOrder.DESCENDING);
    	//throw new PendingException();
    }
    
    @When("^I set the order is \"([^\"]*)\"$")
    public void I_set_that_the_order(String order) throws Throwable {
    	if ("descending".equals(order)) {
    		integerList.setOrder(SortOrder.DESCENDING);
    	} else if ("ascending".equals(order)) {
    		integerList.setOrder(SortOrder.ASCENDING);
    	} else {
    		throw new IllegalArgumentException("Unknown sorting order");
    	}
    	
    	//throw new PendingException();
    }

    @Then("^it should look like:$")
    public void it_should_look_like(List<Integer> items) throws Throwable {
    	// Verify that the ordered list is identical to the expected one
        for (int i = 0 ; i < items.size() ; i++) {
        	assertEquals(items.get(i).intValue(),integerList.get(i));
        }
    }

}
