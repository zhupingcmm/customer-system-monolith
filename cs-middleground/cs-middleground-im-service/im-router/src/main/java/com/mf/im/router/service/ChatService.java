package com.mf.im.router.service;

import com.mf.projects.im.dto.ChatResponse;
import com.mf.projects.im.dto.P2PChatRequest;

public interface ChatService {

    ChatResponse p2pChat(P2PChatRequest request);
}
