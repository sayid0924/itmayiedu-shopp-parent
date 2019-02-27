package com.jzr.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceMacIsNull() {
            addCriterion("device_mac is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMacIsNotNull() {
            addCriterion("device_mac is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMacEqualTo(String value) {
            addCriterion("device_mac =", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacNotEqualTo(String value) {
            addCriterion("device_mac <>", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacGreaterThan(String value) {
            addCriterion("device_mac >", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacGreaterThanOrEqualTo(String value) {
            addCriterion("device_mac >=", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacLessThan(String value) {
            addCriterion("device_mac <", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacLessThanOrEqualTo(String value) {
            addCriterion("device_mac <=", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacLike(String value) {
            addCriterion("device_mac like", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacNotLike(String value) {
            addCriterion("device_mac not like", value, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacIn(List<String> values) {
            addCriterion("device_mac in", values, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacNotIn(List<String> values) {
            addCriterion("device_mac not in", values, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacBetween(String value1, String value2) {
            addCriterion("device_mac between", value1, value2, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceMacNotBetween(String value1, String value2) {
            addCriterion("device_mac not between", value1, value2, "deviceMac");
            return (Criteria) this;
        }

        public Criteria andDeviceIpIsNull() {
            addCriterion("device_ip is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIpIsNotNull() {
            addCriterion("device_ip is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIpEqualTo(String value) {
            addCriterion("device_ip =", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpNotEqualTo(String value) {
            addCriterion("device_ip <>", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpGreaterThan(String value) {
            addCriterion("device_ip >", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpGreaterThanOrEqualTo(String value) {
            addCriterion("device_ip >=", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpLessThan(String value) {
            addCriterion("device_ip <", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpLessThanOrEqualTo(String value) {
            addCriterion("device_ip <=", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpLike(String value) {
            addCriterion("device_ip like", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpNotLike(String value) {
            addCriterion("device_ip not like", value, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpIn(List<String> values) {
            addCriterion("device_ip in", values, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpNotIn(List<String> values) {
            addCriterion("device_ip not in", values, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpBetween(String value1, String value2) {
            addCriterion("device_ip between", value1, value2, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceIpNotBetween(String value1, String value2) {
            addCriterion("device_ip not between", value1, value2, "deviceIp");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andRegisterBedIsNull() {
            addCriterion("register_bed is null");
            return (Criteria) this;
        }

        public Criteria andRegisterBedIsNotNull() {
            addCriterion("register_bed is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterBedEqualTo(String value) {
            addCriterion("register_bed =", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedNotEqualTo(String value) {
            addCriterion("register_bed <>", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedGreaterThan(String value) {
            addCriterion("register_bed >", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedGreaterThanOrEqualTo(String value) {
            addCriterion("register_bed >=", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedLessThan(String value) {
            addCriterion("register_bed <", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedLessThanOrEqualTo(String value) {
            addCriterion("register_bed <=", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedLike(String value) {
            addCriterion("register_bed like", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedNotLike(String value) {
            addCriterion("register_bed not like", value, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedIn(List<String> values) {
            addCriterion("register_bed in", values, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedNotIn(List<String> values) {
            addCriterion("register_bed not in", values, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedBetween(String value1, String value2) {
            addCriterion("register_bed between", value1, value2, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterBedNotBetween(String value1, String value2) {
            addCriterion("register_bed not between", value1, value2, "registerBed");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIsNull() {
            addCriterion("register_state is null");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIsNotNull() {
            addCriterion("register_state is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterStateEqualTo(Integer value) {
            addCriterion("register_state =", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotEqualTo(Integer value) {
            addCriterion("register_state <>", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateGreaterThan(Integer value) {
            addCriterion("register_state >", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_state >=", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateLessThan(Integer value) {
            addCriterion("register_state <", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateLessThanOrEqualTo(Integer value) {
            addCriterion("register_state <=", value, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateIn(List<Integer> values) {
            addCriterion("register_state in", values, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotIn(List<Integer> values) {
            addCriterion("register_state not in", values, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateBetween(Integer value1, Integer value2) {
            addCriterion("register_state between", value1, value2, "registerState");
            return (Criteria) this;
        }

        public Criteria andRegisterStateNotBetween(Integer value1, Integer value2) {
            addCriterion("register_state not between", value1, value2, "registerState");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLike(String value) {
            addCriterion("app_version like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("app_version not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("app_version in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpIsNull() {
            addCriterion("nurseboard_ip is null");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpIsNotNull() {
            addCriterion("nurseboard_ip is not null");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpEqualTo(String value) {
            addCriterion("nurseboard_ip =", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpNotEqualTo(String value) {
            addCriterion("nurseboard_ip <>", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpGreaterThan(String value) {
            addCriterion("nurseboard_ip >", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpGreaterThanOrEqualTo(String value) {
            addCriterion("nurseboard_ip >=", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpLessThan(String value) {
            addCriterion("nurseboard_ip <", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpLessThanOrEqualTo(String value) {
            addCriterion("nurseboard_ip <=", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpLike(String value) {
            addCriterion("nurseboard_ip like", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpNotLike(String value) {
            addCriterion("nurseboard_ip not like", value, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpIn(List<String> values) {
            addCriterion("nurseboard_ip in", values, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpNotIn(List<String> values) {
            addCriterion("nurseboard_ip not in", values, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpBetween(String value1, String value2) {
            addCriterion("nurseboard_ip between", value1, value2, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andNurseboardIpNotBetween(String value1, String value2) {
            addCriterion("nurseboard_ip not between", value1, value2, "nurseboardIp");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeIsNull() {
            addCriterion("last_up_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeIsNotNull() {
            addCriterion("last_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeEqualTo(Date value) {
            addCriterion("last_up_time =", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeNotEqualTo(Date value) {
            addCriterion("last_up_time <>", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeGreaterThan(Date value) {
            addCriterion("last_up_time >", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_up_time >=", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeLessThan(Date value) {
            addCriterion("last_up_time <", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_up_time <=", value, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeIn(List<Date> values) {
            addCriterion("last_up_time in", values, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeNotIn(List<Date> values) {
            addCriterion("last_up_time not in", values, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeBetween(Date value1, Date value2) {
            addCriterion("last_up_time between", value1, value2, "lastUpTime");
            return (Criteria) this;
        }

        public Criteria andLastUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_up_time not between", value1, value2, "lastUpTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}