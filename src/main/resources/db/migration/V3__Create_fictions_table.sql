CREATE TABLE IF NOT EXISTS public.fictions
(
    id bigint NOT NULL,
    name character varying(255),
    type character varying(255),
    provider character varying(255),
    external_id character varying(255),
    screenshot character varying(255),
    year int,
    duration int,
    img_url character varying(255),
    created_by bigint,
    published BOOLEAN,
    CONSTRAINT pk_fictions PRIMARY KEY (id),
    CONSTRAINT fk_fiction_user FOREIGN KEY (created_by)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE SEQUENCE IF NOT EXISTS fictions_id_sequence INCREMENT BY 1 START WITH 1000;
ALTER TABLE public.fictions ALTER COLUMN id SET DEFAULT nextval('fictions_id_sequence');