CREATE TABLE IF NOT EXISTS public.scenes
(
    id bigint NOT NULL,
    description character varying(255),
    end_at bigint,
    episode_name character varying(255),
    episode_number character varying(255),
    name character varying(255),
    season character varying(255),
    segment_type character varying(255),
    start_at bigint,
    screenshot character varying(255),
    created_by bigint NOT NULL,
    place_id bigint,
    CONSTRAINT pk_scenes PRIMARY KEY (id),
    CONSTRAINT fk_scene_user FOREIGN KEY (created_by)
        REFERENCES public.app_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_scene_place FOREIGN KEY (place_id)
            REFERENCES public.places (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION

)