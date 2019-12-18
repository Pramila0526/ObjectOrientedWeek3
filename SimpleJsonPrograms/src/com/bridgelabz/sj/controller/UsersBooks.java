package com.bridgelabz.sj.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.sj.model.UserData;



public class UsersBooks 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
	String path="/home/admin94/Desktop/ObjectOrientedPrograms/SimpeJsonPrograms/UserData.json";
    ObjectMapper mapper=new ObjectMapper();


    @SuppressWarnings("unused")
    
	List<UserData> user = mapper.readValue(path, new TypeReference<List<UserData>>(){});
}
}