/*
 * This file is generated by jOOQ.
 */
package com.github.rinotc.springrestsample.infra.generated.jooq.tables.records;


import com.github.rinotc.springrestsample.infra.generated.jooq.tables.DomainModels;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * ドメインモデルテーブル
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DomainModelsRecord extends UpdatableRecordImpl<DomainModelsRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.domain_models.domain_model_id</code>. ドメインモデルID
     */
    public void setDomainModelId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.domain_models.domain_model_id</code>. ドメインモデルID
     */
    public String getDomainModelId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.domain_models.bounded_context_id</code>.
     * 紐づく境界づけられたコンテキストID
     */
    public void setBoundedContextId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.domain_models.bounded_context_id</code>.
     * 紐づく境界づけられたコンテキストID
     */
    public String getBoundedContextId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.domain_models.ubiquitous_name</code>. ユビキタス名
     */
    public void setUbiquitousName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.domain_models.ubiquitous_name</code>. ユビキタス名
     */
    public String getUbiquitousName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.domain_models.english_name</code>.
     * ドメインモデル英語名（プロジェクト内で一意）
     */
    public void setEnglishName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.domain_models.english_name</code>.
     * ドメインモデル英語名（プロジェクト内で一意）
     */
    public String getEnglishName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.domain_models.knowledge</code>. モデルの知識
     */
    public void setKnowledge(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.domain_models.knowledge</code>. モデルの知識
     */
    public String getKnowledge() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return DomainModels.DOMAIN_MODELS.DOMAIN_MODEL_ID;
    }

    @Override
    public Field<String> field2() {
        return DomainModels.DOMAIN_MODELS.BOUNDED_CONTEXT_ID;
    }

    @Override
    public Field<String> field3() {
        return DomainModels.DOMAIN_MODELS.UBIQUITOUS_NAME;
    }

    @Override
    public Field<String> field4() {
        return DomainModels.DOMAIN_MODELS.ENGLISH_NAME;
    }

    @Override
    public Field<String> field5() {
        return DomainModels.DOMAIN_MODELS.KNOWLEDGE;
    }

    @Override
    public String component1() {
        return getDomainModelId();
    }

    @Override
    public String component2() {
        return getBoundedContextId();
    }

    @Override
    public String component3() {
        return getUbiquitousName();
    }

    @Override
    public String component4() {
        return getEnglishName();
    }

    @Override
    public String component5() {
        return getKnowledge();
    }

    @Override
    public String value1() {
        return getDomainModelId();
    }

    @Override
    public String value2() {
        return getBoundedContextId();
    }

    @Override
    public String value3() {
        return getUbiquitousName();
    }

    @Override
    public String value4() {
        return getEnglishName();
    }

    @Override
    public String value5() {
        return getKnowledge();
    }

    @Override
    public DomainModelsRecord value1(String value) {
        setDomainModelId(value);
        return this;
    }

    @Override
    public DomainModelsRecord value2(String value) {
        setBoundedContextId(value);
        return this;
    }

    @Override
    public DomainModelsRecord value3(String value) {
        setUbiquitousName(value);
        return this;
    }

    @Override
    public DomainModelsRecord value4(String value) {
        setEnglishName(value);
        return this;
    }

    @Override
    public DomainModelsRecord value5(String value) {
        setKnowledge(value);
        return this;
    }

    @Override
    public DomainModelsRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DomainModelsRecord
     */
    public DomainModelsRecord() {
        super(DomainModels.DOMAIN_MODELS);
    }

    /**
     * Create a detached, initialised DomainModelsRecord
     */
    public DomainModelsRecord(String domainModelId, String boundedContextId, String ubiquitousName, String englishName, String knowledge) {
        super(DomainModels.DOMAIN_MODELS);

        setDomainModelId(domainModelId);
        setBoundedContextId(boundedContextId);
        setUbiquitousName(ubiquitousName);
        setEnglishName(englishName);
        setKnowledge(knowledge);
        resetChangedOnNotNull();
    }
}
