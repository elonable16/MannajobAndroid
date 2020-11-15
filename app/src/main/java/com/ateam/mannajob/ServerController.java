package com.ateam.mannajob;

import java.util.HashMap;

public interface ServerController {
    public void ServerSend(String cmd, HashMap<String,String> params);
}
