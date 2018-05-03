package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.report.Report;

public class Parser {
	
	public static Article Article(ResultSet resultSet) throws SQLException {
		Article parsed = new Article();
		
		int index = 1;
		parsed.setId(resultSet.getInt(index++));
		parsed.setTitle(resultSet.getString(index++));
		parsed.setDate(resultSet.getDate(index++));
		index++; // SKIP MODIFICATIONTYPE
		parsed.setContent(resultSet.getString(index++));
		parsed.setWriterId(resultSet.getInt(index++));
		parsed.setTopicId(resultSet.getInt(index++));
		parsed.setLanguageId(resultSet.getInt(index++));
		parsed.setReviewed(resultSet.getInt(index++) == 1);
		
		return parsed;
	}
	
	public static Category Category(ResultSet resultSet) throws SQLException {
		Category parsed = new Category();
		
		int index = 1;
		parsed.setId(resultSet.getInt(index++));
		parsed.setName(resultSet.getString(index++));
		parsed.setParentId(resultSet.getInt(index++));
		
		return parsed;
	}
	
	public static Keyword Keyword(ResultSet resultSet) throws SQLException {
		Keyword parsed = new Keyword();
		
		int index = 1;
		parsed.setId(resultSet.getInt(index++));
		parsed.setKeyword(resultSet.getString(index++));
		
		return parsed;
	}
	
	public static Language Language(ResultSet resultSet) throws SQLException {
		Language parsed = new Language();
		
		int index = 1;
		parsed.setId(resultSet.getInt(index++));
		parsed.setName(resultSet.getString(index++));
		
		return parsed;
	}
	

	public static User User(ResultSet resultSet) throws SQLException {
		User parsed = new User();
		
		int index = 1;
		parsed.setUserId(resultSet.getInt(index++));
		parsed.setUsername(resultSet.getString(index++));
		index++; //SKIP PASSWORD
		parsed.setAdmin(resultSet.getBoolean(index++));
		parsed.setInstitution(resultSet.getString(index++));
		parsed.setScientificDegree(resultSet.getString(index++));
		
		return parsed;
	}
	

	
	public static Report Report(ResultSet resultSet) throws SQLException {
		Report parsed = new Report();
		
		int index = 1;
		parsed.setId(resultSet.getInt(index++));
		parsed.setDescription(resultSet.getString(index++));
		parsed.setTargetId(resultSet.getInt(index++));
		parsed.setUserId(resultSet.getInt(index++));
		
		return parsed;
	}
}
