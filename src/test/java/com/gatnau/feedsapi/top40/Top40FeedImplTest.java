package com.gatnau.feedsapi.top40;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by ilgat on 09/01/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class Top40FeedImplTest {

    /**Scenario 1
    Given a top40 feed
    And No Country is linked to the feed
    When Music feed is retrieved
    Then Default User Country is used to retrieve top40 feed*/

    /**Scenario 2
    Given a Music feed
    And 1 Country is linked to the feed
    When Music feed is retrieved
    Then Country is used to retrieve top40 feed*/

    /**Scenario 3
    Given a Music feed
    And more than 1 Country is linked to the feed
    When Music feed is retrieved
    Then all countries selected are used to retrieve top40 feed*/
}
