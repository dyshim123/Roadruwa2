package com.roadruwa.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.roadruwa.dao.BoardDao;
import com.roadruwa.dao.PointDao;
import com.roadruwa.service.PointService;
import com.roadruwa.vo.PointVo;
import com.roadruwa.vo.UserVo;

@Service("pointService")
public class PointServiceImp implements PointService {
private final Log logger = LogFactory.getLog(getClass());
	
	@Resource(name="pointDao")
	private PointDao pointDao;
	
	@Override
	public void write(PointVo point) {
		pointDao.write(point);
	}
	
	@Override
	public List<PointVo> pointList(String u_id){
		return pointDao.pointList(u_id);
	}
	
	@Override
	public void ptWrite(PointVo vo) {
		pointDao.ptWrite(vo);
	}
	
	@Override
	public String nowpoint(String u_id) {
		return pointDao.nowpoint(u_id);
	}
	
	@Override
	public PointVo points(String u_id) {
		return pointDao.points(u_id);
	}
	
	@Override
	public void userBuy(PointVo vo) {
		pointDao.userBuy(vo);
	}

}
