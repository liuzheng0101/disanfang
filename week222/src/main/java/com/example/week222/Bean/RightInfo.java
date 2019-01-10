package com.example.week222.Bean;

import java.util.List;

public class RightInfo {
    public String code;
    public String msg;
    public List<Cls> data;

    public class Cls{

        public String pcid;
        public String name;
        public List<Pcls> list;
        public class Pcls{
            public String name;
            public String icon;
        }
    }
}
