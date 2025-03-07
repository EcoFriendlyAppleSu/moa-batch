CREATE TABLE IF NOT EXISTS civil_engineering_bid_raw_data (
    idx INT AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(255) NOT NULL UNIQUE COMMENT '유니크한 공고 ID',
    title VARCHAR(255) NOT NULL COMMENT '입찰 공고 제목',
    bid_started_date DATE NOT NULL COMMENT '입찰 시작 날짜',
    bid_ended_date DATE NOT NULL COMMENT '입찰 종료 날짜',
    bid_created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '입찰 공고 생성 날짜',
    institution VARCHAR(255) NOT NULL COMMENT '공고 기관',
    contact_person VARCHAR(255) COMMENT '담당자',
    bid_type VARCHAR(100) NOT NULL COMMENT '입찰 방식',
    bid_description TEXT COMMENT '공고 내용',
    bid_price LONG COMMENT '입찰 가격'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='토목 입찰 공고 Raw Data 테이블';


