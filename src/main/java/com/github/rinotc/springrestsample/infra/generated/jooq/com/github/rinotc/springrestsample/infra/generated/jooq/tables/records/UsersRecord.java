/*
 * This file is generated by jOOQ.
 */
package com.github.rinotc.springrestsample.infra.generated.jooq.tables.records;


import com.github.rinotc.springrestsample.infra.generated.jooq.tables.Users;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * ユーザーテーブル
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record6<String, String, String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.user_id</code>. ユーザーID
     */
    public void setUserId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.users.user_id</code>. ユーザーID
     */
    public String getUserId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.users.user_name</code>. ユーザー名
     */
    public void setUserName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.users.user_name</code>. ユーザー名
     */
    public String getUserName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.email_address</code>. メールアドレス
     */
    public void setEmailAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.users.email_address</code>. メールアドレス
     */
    public String getEmailAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.users.avatar_url</code>. アバター画像のURL
     */
    public void setAvatarUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.users.avatar_url</code>. アバター画像のURL
     */
    public String getAvatarUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.users.created_at</code>. 作成日時
     */
    public void setCreatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.users.created_at</code>. 作成日時
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.users.updated_at</code>. 更新日時
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.users.updated_at</code>. 更新日時
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, String, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Users.USERS.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.USER_NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.EMAIL_ADDRESS;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.AVATAR_URL;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Users.USERS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Users.USERS.UPDATED_AT;
    }

    @Override
    public String component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getUserName();
    }

    @Override
    public String component3() {
        return getEmailAddress();
    }

    @Override
    public String component4() {
        return getAvatarUrl();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public String value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getUserName();
    }

    @Override
    public String value3() {
        return getEmailAddress();
    }

    @Override
    public String value4() {
        return getAvatarUrl();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public UsersRecord value1(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setEmailAddress(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setAvatarUrl(value);
        return this;
    }

    @Override
    public UsersRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UsersRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public UsersRecord values(String value1, String value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(String userId, String userName, String emailAddress, String avatarUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Users.USERS);

        setUserId(userId);
        setUserName(userName);
        setEmailAddress(emailAddress);
        setAvatarUrl(avatarUrl);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
