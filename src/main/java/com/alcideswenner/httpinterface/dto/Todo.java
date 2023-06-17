package com.alcideswenner.httpinterface.dto;

public record Todo(int userId, int id, String title, boolean completed) {
}
