CREATE TABLE IF NOT EXISTS public.app_user
(
    id bigint NOT NULL,
    name character varying(255),
    created_at timestamp without time zone,
    email character varying(255) NOT NULL,
    external_user_id character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    updated_at timestamp without time zone,
    country character varying(255),
    email_verified BOOLEAN,
    CONSTRAINT pk_app_user PRIMARY KEY (id),
    CONSTRAINT uk_external_user_id  UNIQUE (external_user_id)
);

CREATE SEQUENCE app_user_id_sequence INCREMENT BY 1 START WITH 1000;
ALTER TABLE public.app_user ALTER COLUMN id SET DEFAULT nextval('app_user_id_sequence');
