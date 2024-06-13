package com.zeroskill.buytopia.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    EMPTY_FIELD("V-01"),
    INVALID_EMAIL_FORMAT("V-02"),
    PASSWORD_MISS_MATCH("V-03"),
    MEMBER_DUPLICATE("D-01");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }
}

//V-01: 필드가 비어 있음 (Empty Field)
//V-02: 이메일 형식이 잘못됨 (Invalid Email Format)
//V-03: 비밀번호 불일치 (Password Mismatch)
//V-04: 잘못된 형식 (Invalid Format)
//V-05: 최대 길이 초과 (Max Length Exceeded)
//인증 및 권한 에러 (Authentication and Authorization Errors)
//
//A-01: 인증 실패 (Authentication Failed)
//A-02: 권한 없음 (Unauthorized)
//A-03: 접근 금지 (Access Denied)
//A-04: 세션 만료 (Session Expired)
//A-05: 토큰 유효성 실패 (Token Validation Failed)
//중복 데이터 에러 (Duplicate Data Errors)
//
//D-01: 중복 회원 (Duplicate Member)
//D-02: 중복 이메일 (Duplicate Email)
//D-03: 중복 사용자 이름 (Duplicate Username)
//D-04: 중복 데이터 (Duplicate Data)
//D-05: 중복 항목 (Duplicate Item)
//데이터베이스 에러 (Database Errors)
//
//DB-01: 데이터베이스 연결 실패 (Database Connection Failed)
//DB-02: 데이터 무결성 위반 (Data Integrity Violation)
//DB-03: 데이터 조회 실패 (Data Retrieval Failed)
//DB-04: 데이터 저장 실패 (Data Save Failed)
//DB-05: 데이터 삭제 실패 (Data Deletion Failed)
//서버 에러 (Server Errors)
//
//S-01: 내부 서버 오류 (Internal Server Error)
//S-02: 서비스 이용 불가 (Service Unavailable)
//S-03: 시간 초과 (Timeout)
//S-04: 리소스 부족 (Resource Exhaustion)
//S-05: 불명확한 서버 오류 (Unspecified Server Error)
//네트워크 에러 (Network Errors)
//
//N-01: 네트워크 연결 실패 (Network Connection Failed)
//N-02: DNS 조회 실패 (DNS Lookup Failed)
//N-03: 패킷 손실 (Packet Loss)
//N-04: 연결 시간 초과 (Connection Timeout)
//N-05: 프로토콜 오류 (Protocol Error)