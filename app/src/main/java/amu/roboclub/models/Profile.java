package amu.roboclub.models;

import java.util.HashMap;

public class Profile {
    public String name, position, thumbnail;
    public HashMap<String, String> links;
    public ProfileInfo profile_info;
    public int rank;

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", links=" + links +
                ", profile_info=" + profile_info +
                ", rank=" + rank +
                '}';
    }
}
