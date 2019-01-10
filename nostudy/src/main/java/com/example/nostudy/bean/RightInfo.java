package com.example.nostudy.bean;

import java.util.List;

public class RightInfo {
    public String code;
    public String msg;
    public List<Right> data;
    public class Right{
        public String pcid;
        public String name;
        public List<Rights> list;
        public class Rights{
            public String name;
            public String icon;
        }
    }
}
