

CREATE TABLE student ( student_id INT NOT NULL
                         student_name VARCHAR (225),
                         birthday DATE,
                            student_id INT
);
CREATE TABLE professor ( professor_id INT NOT NULL
                            professor_name VARCHAR(225),
                            hire_date DATE ,
                            has_phd INT
);

CREATE TABLE building  (building_id INT NOT NULL,
                            building_name INT ,
                            date_built DATE,
                            coordinates VARCHAR,
                            capacity INT,
                            PRIMARY KEY (building_id)
);

CREATE TABLE course (course_id INT NOT NULL,
                        room_id int NOT NULL,
                        name VARCHAR (225),
                        creds INT,
                        description VARCHAR (225),
                        PRIMARY KEY (course_id),
                        FOREIGN KEY (room_id) REFERENCES ROOM (room_id),

);
 CREATE TABLE book (book_id INT NOT NULL,
                        book_name INT,
                        edition INT,
                        author VARCHAR,
                        price DOUBLE,
                        course_id INT,
                        PRIMARY KEY (book_id),
                        FOREIGN KEY (course_id) REFERENCES course(course_id),
;
CREATE TABLE room (room_id INT NOT NULL,
                        capacity INT,
                        room_number INT,
                        building_id INT,
                        PRIMARY KEY (room_id),
                        FOREIGN KEY (building_id) REFERENCES building(building_id)
;
 CREATE TABLE professorcourse ( professor_course_id INT NOT NULL,
                              professor_id INT,
                              course_id INT,
                              PRIMARY KEY (professor_course_id),
                              FOREIGN KEY (professor_id)REFERENCES professor(professor_id),
                              FOREIGN KEY (course_id)REFERENCES course(course_id)
;
CREATE TABLE studentcourse ( student_course_id INT NOT NULL,
                            course_id INT,
                            student_id INT,
                            PRIMARY KEY (student_course_id) ,
                            FOREIGN KEY (course_id)REFERENCES course(course_id),
                            FOREIGN KEY (student_id)REFERENCES student(student_id)
;