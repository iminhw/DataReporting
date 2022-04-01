package com.cap.datareporting.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UReqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UReqExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReqStatusIsNull() {
            addCriterion("req_status is null");
            return (Criteria) this;
        }

        public Criteria andReqStatusIsNotNull() {
            addCriterion("req_status is not null");
            return (Criteria) this;
        }

        public Criteria andReqStatusEqualTo(Byte value) {
            addCriterion("req_status =", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotEqualTo(Byte value) {
            addCriterion("req_status <>", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusGreaterThan(Byte value) {
            addCriterion("req_status >", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("req_status >=", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusLessThan(Byte value) {
            addCriterion("req_status <", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusLessThanOrEqualTo(Byte value) {
            addCriterion("req_status <=", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusIn(List<Byte> values) {
            addCriterion("req_status in", values, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotIn(List<Byte> values) {
            addCriterion("req_status not in", values, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusBetween(Byte value1, Byte value2) {
            addCriterion("req_status between", value1, value2, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("req_status not between", value1, value2, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andZyIsNull() {
            addCriterion("zy is null");
            return (Criteria) this;
        }

        public Criteria andZyIsNotNull() {
            addCriterion("zy is not null");
            return (Criteria) this;
        }

        public Criteria andZyEqualTo(String value) {
            addCriterion("zy =", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotEqualTo(String value) {
            addCriterion("zy <>", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThan(String value) {
            addCriterion("zy >", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThanOrEqualTo(String value) {
            addCriterion("zy >=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThan(String value) {
            addCriterion("zy <", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThanOrEqualTo(String value) {
            addCriterion("zy <=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLike(String value) {
            addCriterion("zy like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotLike(String value) {
            addCriterion("zy not like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyIn(List<String> values) {
            addCriterion("zy in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotIn(List<String> values) {
            addCriterion("zy not in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyBetween(String value1, String value2) {
            addCriterion("zy between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotBetween(String value1, String value2) {
            addCriterion("zy not between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andGklbIsNull() {
            addCriterion("gklb is null");
            return (Criteria) this;
        }

        public Criteria andGklbIsNotNull() {
            addCriterion("gklb is not null");
            return (Criteria) this;
        }

        public Criteria andGklbEqualTo(String value) {
            addCriterion("gklb =", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbNotEqualTo(String value) {
            addCriterion("gklb <>", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbGreaterThan(String value) {
            addCriterion("gklb >", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbGreaterThanOrEqualTo(String value) {
            addCriterion("gklb >=", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbLessThan(String value) {
            addCriterion("gklb <", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbLessThanOrEqualTo(String value) {
            addCriterion("gklb <=", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbLike(String value) {
            addCriterion("gklb like", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbNotLike(String value) {
            addCriterion("gklb not like", value, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbIn(List<String> values) {
            addCriterion("gklb in", values, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbNotIn(List<String> values) {
            addCriterion("gklb not in", values, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbBetween(String value1, String value2) {
            addCriterion("gklb between", value1, value2, "gklb");
            return (Criteria) this;
        }

        public Criteria andGklbNotBetween(String value1, String value2) {
            addCriterion("gklb not between", value1, value2, "gklb");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkIsNull() {
            addCriterion("req_remark is null");
            return (Criteria) this;
        }

        public Criteria andReqRemarkIsNotNull() {
            addCriterion("req_remark is not null");
            return (Criteria) this;
        }

        public Criteria andReqRemarkEqualTo(String value) {
            addCriterion("req_remark =", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkNotEqualTo(String value) {
            addCriterion("req_remark <>", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkGreaterThan(String value) {
            addCriterion("req_remark >", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("req_remark >=", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkLessThan(String value) {
            addCriterion("req_remark <", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkLessThanOrEqualTo(String value) {
            addCriterion("req_remark <=", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkLike(String value) {
            addCriterion("req_remark like", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkNotLike(String value) {
            addCriterion("req_remark not like", value, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkIn(List<String> values) {
            addCriterion("req_remark in", values, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkNotIn(List<String> values) {
            addCriterion("req_remark not in", values, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkBetween(String value1, String value2) {
            addCriterion("req_remark between", value1, value2, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andReqRemarkNotBetween(String value1, String value2) {
            addCriterion("req_remark not between", value1, value2, "reqRemark");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrIsNull() {
            addCriterion("imegs_url_arr is null");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrIsNotNull() {
            addCriterion("imegs_url_arr is not null");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrEqualTo(String value) {
            addCriterion("imegs_url_arr =", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrNotEqualTo(String value) {
            addCriterion("imegs_url_arr <>", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrGreaterThan(String value) {
            addCriterion("imegs_url_arr >", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrGreaterThanOrEqualTo(String value) {
            addCriterion("imegs_url_arr >=", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrLessThan(String value) {
            addCriterion("imegs_url_arr <", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrLessThanOrEqualTo(String value) {
            addCriterion("imegs_url_arr <=", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrLike(String value) {
            addCriterion("imegs_url_arr like", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrNotLike(String value) {
            addCriterion("imegs_url_arr not like", value, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrIn(List<String> values) {
            addCriterion("imegs_url_arr in", values, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrNotIn(List<String> values) {
            addCriterion("imegs_url_arr not in", values, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrBetween(String value1, String value2) {
            addCriterion("imegs_url_arr between", value1, value2, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andImegsUrlArrNotBetween(String value1, String value2) {
            addCriterion("imegs_url_arr not between", value1, value2, "imegsUrlArr");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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