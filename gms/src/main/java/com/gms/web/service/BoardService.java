package com.gms.web.service;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.ArticleDTO;
import com.gms.web.domain.MemberDTO;

public interface BoardService {
	public void add(ArticleDTO p);
	public List<?> list(Map<?,?> p);
	public List<?> search(Map<?,?> p);
	public MemberDTO retrieve(ArticleDTO p);
	public int count(Map<?,?> p);
	public void modify(ArticleDTO p);
	public void remove(ArticleDTO p);
}
