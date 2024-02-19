/*
 * This file is generated by jOOQ.
 */
package com.github.rinotc.springrestsample.infra.generated.jooq;


import com.github.rinotc.springrestsample.infra.generated.jooq.tables.BoundedContexts;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.DomainModels;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.Users;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index DOMAIN_MODEL_PROJECT_ID_ENGLISH_NAME_UINDEX = Internal.createIndex(DSL.name("domain_model_project_id_english_name_uindex"), DomainModels.DOMAIN_MODELS, new OrderField[] { DomainModels.DOMAIN_MODELS.BOUNDED_CONTEXT_ID, DomainModels.DOMAIN_MODELS.ENGLISH_NAME }, true);
    public static final Index UQ_BOUNDED_CONTEXTS_BOUNDED_CONTEXT_ALIAS = Internal.createIndex(DSL.name("uq_bounded_contexts_bounded_context_alias"), BoundedContexts.BOUNDED_CONTEXTS, new OrderField[] { BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS }, true);
    public static final Index USERS_EMAIL_ADDRESS_UINDEX = Internal.createIndex(DSL.name("users_email_address_uindex"), Users.USERS, new OrderField[] { Users.USERS.EMAIL_ADDRESS }, true);
}
