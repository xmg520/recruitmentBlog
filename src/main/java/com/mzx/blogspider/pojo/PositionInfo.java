package com.mzx.blogspider.pojo;

import java.util.ArrayList;

public class PositionInfo
{
    private String id;
    private String jobName;
    private String salary;
    private String city_name;
    private String createDate;
    private String endDate;
    private String welfare;
    private String workingExp;
    private String eduLevel_name;
    private String company_name;
    private String companySize;
    private String responsibility;
    private String place;
    private String emplType;
    private ArrayList<String> welfareList = new ArrayList();

    public String getResponsibility()
    {
        return this.responsibility;
    }

    public void setResponsibility(String responsibility) {
        if (!"".equals(responsibility)) {
            String replace = responsibility.replace("岗位职责:", "");
            String replace1 = replace.replace("任职要求：", "");
            this.responsibility = replace1;
        } else {
            this.responsibility = responsibility;
        }
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmplType() {
        return this.emplType;
    }

    public void setEmplType(String emplType) {
        this.emplType = emplType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getWelfareList()
    {
        return this.welfareList;
    }

    public void setWelfareList(ArrayList<String> welfareList) {
        this.welfareList = welfareList;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity_name() {
        return this.city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWelfare() {
        return this.welfare;
    }

    public void setWelfare(String welfare) {
        if (!"".equals(welfare)) {
            String[] split = welfare.split(",");
            for (String s : split) {
                this.welfareList.add(s);
            }
        }
        else {
            this.welfareList.add("无");
            welfare = "无";
        }
        this.welfare = welfare;
    }

    public String getWorkingExp() {
        return this.workingExp;
    }

    public void setWorkingExp(String workingExp) {
        this.workingExp = workingExp;
    }

    public String getEduLevel_name() {
        return this.eduLevel_name;
    }

    public void setEduLevel_name(String eduLevel_name) {
        this.eduLevel_name = eduLevel_name;
    }

    public String getCompany_name() {
        return this.company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanySize() {
        return this.companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }
}
