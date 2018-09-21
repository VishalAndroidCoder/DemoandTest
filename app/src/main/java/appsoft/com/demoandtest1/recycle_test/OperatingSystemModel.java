package appsoft.com.demoandtest1.recycle_test;

import android.support.annotation.NonNull;

public class OperatingSystemModel {

    @NonNull
    private String name = null;

    @NonNull
    private String companyName = null;

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
}
