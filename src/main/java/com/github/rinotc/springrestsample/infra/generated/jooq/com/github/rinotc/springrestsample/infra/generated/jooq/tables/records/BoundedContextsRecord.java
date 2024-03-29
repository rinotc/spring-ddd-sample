/*
 * This file is generated by jOOQ.
 */
package com.github.rinotc.springrestsample.infra.generated.jooq.tables.records;


import com.github.rinotc.springrestsample.infra.generated.jooq.tables.BoundedContexts;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * プロジェクトテーブル
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BoundedContextsRecord extends UpdatableRecordImpl<BoundedContextsRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.bounded_contexts.bounded_context_id</code>.
     * 境界づけられたコンテキストID
     */
    public void setBoundedContextId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.bounded_contexts.bounded_context_id</code>.
     * 境界づけられたコンテキストID
     */
    public String getBoundedContextId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.bounded_contexts.bounded_context_alias</code>.
     * 境界づけられたコンテキストのエイリアス
     */
    public void setBoundedContextAlias(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.bounded_contexts.bounded_context_alias</code>.
     * 境界づけられたコンテキストのエイリアス
     */
    public String getBoundedContextAlias() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.bounded_contexts.bounded_context_name</code>.
     * 境界づけられたコンテキストの名称
     */
    public void setBoundedContextName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.bounded_contexts.bounded_context_name</code>.
     * 境界づけられたコンテキストの名称
     */
    public String getBoundedContextName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.bounded_contexts.bounded_context_overview</code>.
     * 境界づけられたコンテキストの概要
     */
    public void setBoundedContextOverview(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.bounded_contexts.bounded_context_overview</code>.
     * 境界づけられたコンテキストの概要
     */
    public String getBoundedContextOverview() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID;
    }

    @Override
    public Field<String> field2() {
        return BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS;
    }

    @Override
    public Field<String> field3() {
        return BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_NAME;
    }

    @Override
    public Field<String> field4() {
        return BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_OVERVIEW;
    }

    @Override
    public String component1() {
        return getBoundedContextId();
    }

    @Override
    public String component2() {
        return getBoundedContextAlias();
    }

    @Override
    public String component3() {
        return getBoundedContextName();
    }

    @Override
    public String component4() {
        return getBoundedContextOverview();
    }

    @Override
    public String value1() {
        return getBoundedContextId();
    }

    @Override
    public String value2() {
        return getBoundedContextAlias();
    }

    @Override
    public String value3() {
        return getBoundedContextName();
    }

    @Override
    public String value4() {
        return getBoundedContextOverview();
    }

    @Override
    public BoundedContextsRecord value1(String value) {
        setBoundedContextId(value);
        return this;
    }

    @Override
    public BoundedContextsRecord value2(String value) {
        setBoundedContextAlias(value);
        return this;
    }

    @Override
    public BoundedContextsRecord value3(String value) {
        setBoundedContextName(value);
        return this;
    }

    @Override
    public BoundedContextsRecord value4(String value) {
        setBoundedContextOverview(value);
        return this;
    }

    @Override
    public BoundedContextsRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BoundedContextsRecord
     */
    public BoundedContextsRecord() {
        super(BoundedContexts.BOUNDED_CONTEXTS);
    }

    /**
     * Create a detached, initialised BoundedContextsRecord
     */
    public BoundedContextsRecord(String boundedContextId, String boundedContextAlias, String boundedContextName, String boundedContextOverview) {
        super(BoundedContexts.BOUNDED_CONTEXTS);

        setBoundedContextId(boundedContextId);
        setBoundedContextAlias(boundedContextAlias);
        setBoundedContextName(boundedContextName);
        setBoundedContextOverview(boundedContextOverview);
        resetChangedOnNotNull();
    }
}
