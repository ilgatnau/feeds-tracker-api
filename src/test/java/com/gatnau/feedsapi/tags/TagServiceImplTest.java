package com.gatnau.feedsapi.tags;

import com.gatnau.feedsapi.domain.Tag;
import com.gatnau.feedsapi.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by ilgat on 09/01/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class TagServiceImplTest {

    TagServiceImpl tagService;

    Tag mockTag = new Tag();
    User mockUser = new User();

    @Before
    public void setup() {
        //Tag tag= new Tag();
        //User user = new User();

    }

    @Test
    public void givenTagAnUser_whenAssignTagToUser_thenReturnTagWithId() {
        given(tagService.addTag(any(), any())).willReturn(mockTag);

        Tag tag = tagService.addTag(mockTag, mockUser);

        assertEquals(tag.getId(), mockTag.getId());
    }
}
