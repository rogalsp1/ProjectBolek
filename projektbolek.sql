--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: bolekshema; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA bolekshema;


SET search_path = bolekshema, pg_catalog;

SET default_with_oids = false;

--
-- Name: charge; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE charge (
    id integer NOT NULL,
    to_pay numeric(10,2),
    service_date timestamp without time zone NOT NULL,
    payment_date timestamp without time zone,
    patient_id integer NOT NULL,
    examination_id integer
);


--
-- Name: charge_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE charge_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: charge_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE charge_id_seq OWNED BY charge.id;


--
-- Name: contact_details; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE contact_details (
    id integer NOT NULL,
    country character varying(20) NOT NULL,
    province character varying(20) NOT NULL,
    city character varying(20) NOT NULL,
    street character varying(50) NOT NULL,
    phone_number character varying(20) NOT NULL,
    patient_id integer NOT NULL
);


--
-- Name: contact_details_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE contact_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: contact_details_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE contact_details_id_seq OWNED BY contact_details.id;


--
-- Name: discount; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE discount (
    id integer NOT NULL,
    discount numeric(10,2),
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone,
    patient_id integer NOT NULL,
    service_id integer NOT NULL
);


--
-- Name: discount_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE discount_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: discount_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE discount_id_seq OWNED BY discount.id;


--
-- Name: examination; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE examination (
    id integer NOT NULL,
    service_id integer NOT NULL,
    visit_id integer NOT NULL,
    service_date timestamp without time zone
);


--
-- Name: examination_result; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE examination_result (
    id integer NOT NULL,
    result bytea,
    file_name character varying(255) NOT NULL,
    examination_id integer
);


--
-- Name: examination_result_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE examination_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: examination_result_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE examination_result_id_seq OWNED BY examination_result.id;


--
-- Name: patient; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE patient (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    sex character varying(50) NOT NULL,
    pesel character varying(50) NOT NULL,
    birthdate timestamp without time zone NOT NULL,
    registration_date timestamp without time zone DEFAULT ('now'::text)::timestamp without time zone,
    active boolean DEFAULT true
);


--
-- Name: patient_history; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE patient_history (
    id integer NOT NULL,
    date timestamp without time zone NOT NULL,
    description text NOT NULL,
    patient_id integer NOT NULL
);


--
-- Name: patient_history_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE patient_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: patient_history_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE patient_history_id_seq OWNED BY patient_history.id;


--
-- Name: patient_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE patient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: patient_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE patient_id_seq OWNED BY patient.id;


--
-- Name: personel_inaccessibility; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE personel_inaccessibility (
    id integer NOT NULL,
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    personel_id integer NOT NULL
);


--
-- Name: personel_inaccessibility_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE personel_inaccessibility_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: personel_inaccessibility_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE personel_inaccessibility_id_seq OWNED BY personel_inaccessibility.id;


--
-- Name: service; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE service (
    id integer NOT NULL,
    description text,
    price numeric(10,2),
    service_name character varying(255)
);


--
-- Name: service_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: service_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE service_id_seq OWNED BY service.id;


--
-- Name: system_user; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE system_user (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    phone_number character varying(15),
    password character varying(64)
);


--
-- Name: system_user_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE system_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: system_user_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE system_user_id_seq OWNED BY system_user.id;


--
-- Name: user_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE user_id_seq OWNED BY system_user.id;


--
-- Name: user_roles; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE user_roles (
    id integer NOT NULL,
    role character varying(45) NOT NULL,
    user_id integer NOT NULL
);


--
-- Name: visit; Type: TABLE; Schema: bolekshema; Owner: -
--

CREATE TABLE visit (
    id integer NOT NULL,
    notes text,
    user_id integer,
    visit_date timestamp without time zone,
    patient_id integer NOT NULL
);


--
-- Name: visit_service_id_seq; Type: SEQUENCE; Schema: bolekshema; Owner: -
--

CREATE SEQUENCE visit_service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: visit_service_id_seq; Type: SEQUENCE OWNED BY; Schema: bolekshema; Owner: -
--

ALTER SEQUENCE visit_service_id_seq OWNED BY examination.id;


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY charge ALTER COLUMN id SET DEFAULT nextval('charge_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY contact_details ALTER COLUMN id SET DEFAULT nextval('contact_details_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY discount ALTER COLUMN id SET DEFAULT nextval('discount_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination ALTER COLUMN id SET DEFAULT nextval('visit_service_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination_result ALTER COLUMN id SET DEFAULT nextval('examination_result_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY patient ALTER COLUMN id SET DEFAULT nextval('patient_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY patient_history ALTER COLUMN id SET DEFAULT nextval('patient_history_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY personel_inaccessibility ALTER COLUMN id SET DEFAULT nextval('personel_inaccessibility_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY service ALTER COLUMN id SET DEFAULT nextval('service_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY system_user ALTER COLUMN id SET DEFAULT nextval('system_user_id_seq'::regclass);


--
-- Name: charge_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY charge
    ADD CONSTRAINT charge_pkey PRIMARY KEY (id);


--
-- Name: contact_details_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY contact_details
    ADD CONSTRAINT contact_details_pkey PRIMARY KEY (id);


--
-- Name: discount_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY discount
    ADD CONSTRAINT discount_pkey PRIMARY KEY (id);


--
-- Name: examination_result_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination_result
    ADD CONSTRAINT examination_result_pkey PRIMARY KEY (id);


--
-- Name: patient_history_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY patient_history
    ADD CONSTRAINT patient_history_pkey PRIMARY KEY (id);


--
-- Name: patient_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id);


--
-- Name: service_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY service
    ADD CONSTRAINT service_pkey PRIMARY KEY (id);


--
-- Name: user_id_pk; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT user_id_pk PRIMARY KEY (id);


--
-- Name: user_roles_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (id);


--
-- Name: visit_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY visit
    ADD CONSTRAINT visit_pkey PRIMARY KEY (id);


--
-- Name: visit_service_pkey; Type: CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination
    ADD CONSTRAINT visit_service_pkey PRIMARY KEY (id);


--
-- Name: charge_examination_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY charge
    ADD CONSTRAINT charge_examination_id_fk FOREIGN KEY (examination_id) REFERENCES examination(id);


--
-- Name: charge_patient_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY charge
    ADD CONSTRAINT charge_patient_id_fk FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- Name: contact_details_patient_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY contact_details
    ADD CONSTRAINT contact_details_patient_id_fk FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- Name: discount_patient_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY discount
    ADD CONSTRAINT discount_patient_id_fk FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- Name: discount_service_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY discount
    ADD CONSTRAINT discount_service_id_fk FOREIGN KEY (service_id) REFERENCES service(id);


--
-- Name: examination_result_examination_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination_result
    ADD CONSTRAINT examination_result_examination_id_fk FOREIGN KEY (examination_id) REFERENCES examination(id);


--
-- Name: fk_user_id; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES system_user(id);


--
-- Name: patient_history_patient_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY patient_history
    ADD CONSTRAINT patient_history_patient_id_fk FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- Name: personel_inaccessibility_user_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY personel_inaccessibility
    ADD CONSTRAINT personel_inaccessibility_user_id_fk FOREIGN KEY (personel_id) REFERENCES system_user(id);


--
-- Name: visit_patient_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY visit
    ADD CONSTRAINT visit_patient_id_fk FOREIGN KEY (patient_id) REFERENCES patient(id);


--
-- Name: visit_service_service_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination
    ADD CONSTRAINT visit_service_service_id_fk FOREIGN KEY (service_id) REFERENCES service(id);


--
-- Name: visit_service_visit_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY examination
    ADD CONSTRAINT visit_service_visit_id_fk FOREIGN KEY (visit_id) REFERENCES visit(id);


--
-- Name: visit_system_user_id_fk; Type: FK CONSTRAINT; Schema: bolekshema; Owner: -
--

ALTER TABLE ONLY visit
    ADD CONSTRAINT visit_system_user_id_fk FOREIGN KEY (user_id) REFERENCES system_user(id);


--
-- PostgreSQL database dump complete
--

