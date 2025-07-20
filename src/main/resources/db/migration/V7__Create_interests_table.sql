CREATE TABLE IF NOT EXISTS public.interests
(
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    fiction_id bigint NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_interests PRIMARY KEY (id),
    CONSTRAINT fk_interests_user FOREIGN KEY (user_id)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fk_interests_fiction FOREIGN KEY (fiction_id)
        REFERENCES public.fictions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT uk_interests_user_fiction UNIQUE (user_id, fiction_id)
);

CREATE SEQUENCE interests_id_sequence INCREMENT BY 1 START WITH 1000;
ALTER TABLE public.interests ALTER COLUMN id SET DEFAULT nextval('interests_id_sequence');

CREATE INDEX idx_interests_user_id ON public.interests (user_id);
CREATE INDEX idx_interests_fiction_id ON public.interests (fiction_id); 