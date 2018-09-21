package appsoft.com.demoandtest1.recycle_test;

import android.support.annotation.NonNull;

public class DeveloperNameModel {
    @NonNull
    private String name = null;
    @NonNull
    private String companyName = null;
    private int age = 0;

    public DeveloperNameModel(@NonNull String name, @NonNull String companyName, int age) {
        this.name = name;
        this.companyName = companyName;
        this.age = age;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NonNull String companyName) {
        this.companyName = companyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
