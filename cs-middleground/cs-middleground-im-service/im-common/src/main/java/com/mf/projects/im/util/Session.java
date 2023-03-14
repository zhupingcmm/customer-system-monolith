package com.mf.projects.im.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    private String userId;
    private String userName;
    private String password;
}
