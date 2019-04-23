package com.xiadiao.fruits.mall.backend.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(String value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(String value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(String value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(String value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(String value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(String value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLike(String value) {
            addCriterion("productId like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotLike(String value) {
            addCriterion("productId not like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<String> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<String> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(String value1, String value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(String value1, String value2) {
            addCriterion("productId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductmsgIsNull() {
            addCriterion("productMsg is null");
            return (Criteria) this;
        }

        public Criteria andProductmsgIsNotNull() {
            addCriterion("productMsg is not null");
            return (Criteria) this;
        }

        public Criteria andProductmsgEqualTo(String value) {
            addCriterion("productMsg =", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgNotEqualTo(String value) {
            addCriterion("productMsg <>", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgGreaterThan(String value) {
            addCriterion("productMsg >", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgGreaterThanOrEqualTo(String value) {
            addCriterion("productMsg >=", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgLessThan(String value) {
            addCriterion("productMsg <", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgLessThanOrEqualTo(String value) {
            addCriterion("productMsg <=", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgLike(String value) {
            addCriterion("productMsg like", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgNotLike(String value) {
            addCriterion("productMsg not like", value, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgIn(List<String> values) {
            addCriterion("productMsg in", values, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgNotIn(List<String> values) {
            addCriterion("productMsg not in", values, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgBetween(String value1, String value2) {
            addCriterion("productMsg between", value1, value2, "productmsg");
            return (Criteria) this;
        }

        public Criteria andProductmsgNotBetween(String value1, String value2) {
            addCriterion("productMsg not between", value1, value2, "productmsg");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subTitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subTitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subTitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subTitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subTitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subTitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subTitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subTitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subTitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subTitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subTitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subTitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subTitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subTitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallIsNull() {
            addCriterion("productImageSmall is null");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallIsNotNull() {
            addCriterion("productImageSmall is not null");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallEqualTo(String value) {
            addCriterion("productImageSmall =", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallNotEqualTo(String value) {
            addCriterion("productImageSmall <>", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallGreaterThan(String value) {
            addCriterion("productImageSmall >", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallGreaterThanOrEqualTo(String value) {
            addCriterion("productImageSmall >=", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallLessThan(String value) {
            addCriterion("productImageSmall <", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallLessThanOrEqualTo(String value) {
            addCriterion("productImageSmall <=", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallLike(String value) {
            addCriterion("productImageSmall like", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallNotLike(String value) {
            addCriterion("productImageSmall not like", value, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallIn(List<String> values) {
            addCriterion("productImageSmall in", values, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallNotIn(List<String> values) {
            addCriterion("productImageSmall not in", values, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallBetween(String value1, String value2) {
            addCriterion("productImageSmall between", value1, value2, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagesmallNotBetween(String value1, String value2) {
            addCriterion("productImageSmall not between", value1, value2, "productimagesmall");
            return (Criteria) this;
        }

        public Criteria andProductimagebigIsNull() {
            addCriterion("productImageBig is null");
            return (Criteria) this;
        }

        public Criteria andProductimagebigIsNotNull() {
            addCriterion("productImageBig is not null");
            return (Criteria) this;
        }

        public Criteria andProductimagebigEqualTo(String value) {
            addCriterion("productImageBig =", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigNotEqualTo(String value) {
            addCriterion("productImageBig <>", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigGreaterThan(String value) {
            addCriterion("productImageBig >", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigGreaterThanOrEqualTo(String value) {
            addCriterion("productImageBig >=", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigLessThan(String value) {
            addCriterion("productImageBig <", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigLessThanOrEqualTo(String value) {
            addCriterion("productImageBig <=", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigLike(String value) {
            addCriterion("productImageBig like", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigNotLike(String value) {
            addCriterion("productImageBig not like", value, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigIn(List<String> values) {
            addCriterion("productImageBig in", values, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigNotIn(List<String> values) {
            addCriterion("productImageBig not in", values, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigBetween(String value1, String value2) {
            addCriterion("productImageBig between", value1, value2, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andProductimagebigNotBetween(String value1, String value2) {
            addCriterion("productImageBig not between", value1, value2, "productimagebig");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Long value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Long value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Long value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Long value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Long value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Long value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Long> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Long> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Long value1, Long value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Long value1, Long value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNull() {
            addCriterion("salePrice is null");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNotNull() {
            addCriterion("salePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSalepriceEqualTo(Long value) {
            addCriterion("salePrice =", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotEqualTo(Long value) {
            addCriterion("salePrice <>", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThan(Long value) {
            addCriterion("salePrice >", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThanOrEqualTo(Long value) {
            addCriterion("salePrice >=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThan(Long value) {
            addCriterion("salePrice <", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThanOrEqualTo(Long value) {
            addCriterion("salePrice <=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceIn(List<Long> values) {
            addCriterion("salePrice in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotIn(List<Long> values) {
            addCriterion("salePrice not in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceBetween(Long value1, Long value2) {
            addCriterion("salePrice between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotBetween(Long value1, Long value2) {
            addCriterion("salePrice not between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andLimitnumIsNull() {
            addCriterion("limitNum is null");
            return (Criteria) this;
        }

        public Criteria andLimitnumIsNotNull() {
            addCriterion("limitNum is not null");
            return (Criteria) this;
        }

        public Criteria andLimitnumEqualTo(Long value) {
            addCriterion("limitNum =", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotEqualTo(Long value) {
            addCriterion("limitNum <>", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumGreaterThan(Long value) {
            addCriterion("limitNum >", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumGreaterThanOrEqualTo(Long value) {
            addCriterion("limitNum >=", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumLessThan(Long value) {
            addCriterion("limitNum <", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumLessThanOrEqualTo(Long value) {
            addCriterion("limitNum <=", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumIn(List<Long> values) {
            addCriterion("limitNum in", values, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotIn(List<Long> values) {
            addCriterion("limitNum not in", values, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumBetween(Long value1, Long value2) {
            addCriterion("limitNum between", value1, value2, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotBetween(Long value1, Long value2) {
            addCriterion("limitNum not between", value1, value2, "limitnum");
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