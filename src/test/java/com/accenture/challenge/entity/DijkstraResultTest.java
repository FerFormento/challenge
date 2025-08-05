package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.DijkstraResult;

@SpringBootTest
public class DijkstraResultTest {
	
	@Test
	void testDijkstraResult() {
		List<Integer> camino = new ArrayList<Integer>();
		camino.add(1);
		var dijkstraResult = new DijkstraResult(12, camino);

	    assertEquals(1, dijkstraResult.camino().get(0));
	    assertEquals(12, dijkstraResult.costoTotal());
	}
}
