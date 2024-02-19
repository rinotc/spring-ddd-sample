/*
 * This file is generated by jOOQ.
 */
package com.github.rinotc.springrestsample.infra.generated.jooq;


import com.github.rinotc.springrestsample.infra.generated.jooq.tables.AuthInfos;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.BoundedContexts;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.DomainModels;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.Users;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.records.AuthInfosRecord;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.records.BoundedContextsRecord;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.records.DomainModelsRecord;
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthInfosRecord> AUTH_INFO_PK = Internal.createUniqueKey(AuthInfos.AUTH_INFOS, DSL.name("auth_info_pk"), new TableField[] { AuthInfos.AUTH_INFOS.AUTH_INFO_ID }, true);
    public static final UniqueKey<BoundedContextsRecord> USER_PK = Internal.createUniqueKey(BoundedContexts.BOUNDED_CONTEXTS, DSL.name("user_pk"), new TableField[] { BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID }, true);
    public static final UniqueKey<DomainModelsRecord> DOMAIN_MODEL_PK = Internal.createUniqueKey(DomainModels.DOMAIN_MODELS, DSL.name("domain_model_pk"), new TableField[] { DomainModels.DOMAIN_MODELS.DOMAIN_MODEL_ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PK = Internal.createUniqueKey(Users.USERS, DSL.name("users_pk"), new TableField[] { Users.USERS.USER_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DomainModelsRecord, BoundedContextsRecord> DOMAIN_MODELS__DOMAIN_MODELS_BOUNDED_CONTEXTS_BOUNDED_CONTEXT_ID_FK = Internal.createForeignKey(DomainModels.DOMAIN_MODELS, DSL.name("domain_models_bounded_contexts_bounded_context_id_fk"), new TableField[] { DomainModels.DOMAIN_MODELS.BOUNDED_CONTEXT_ID }, Keys.USER_PK, new TableField[] { BoundedContexts.BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID }, true);
}