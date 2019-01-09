package com.gatnau.feedsapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ilgat on 09/01/2019.
 */
@Getter
@Setter
@NoArgsConstructor
public class Tag {
    Long id;
    String name, description;
}
