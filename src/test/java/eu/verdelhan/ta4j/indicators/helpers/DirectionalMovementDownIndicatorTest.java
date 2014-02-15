package eu.verdelhan.ta4j.indicators.helpers;

import eu.verdelhan.ta4j.indicators.helpers.DirectionalMovementDownIndicator;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.mocks.MockTick;
import eu.verdelhan.ta4j.mocks.MockTimeSeries;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


public class DirectionalMovementDownIndicatorTest {

	
	@Test
	public void testZeroDirectionalMovement()
	{
		MockTick yesterdayTick = new MockTick(0, 0, 10, 2);
		MockTick todayTick = new MockTick(0, 0, 6, 6);
		List<Tick> ticks = new ArrayList<Tick>();
		ticks.add(yesterdayTick);
		ticks.add(todayTick);
		MockTimeSeries series = new MockTimeSeries(ticks);
		DirectionalMovementDownIndicator down = new DirectionalMovementDownIndicator(series);
		assertThat(down.getValue(1)).isEqualTo(0d);
	}
	
	@Test
	public void testZeroDirectionalMovement2()
	{
		MockTick yesterdayTick = new MockTick(0, 0, 6, 12);
		MockTick todayTick = new MockTick(0, 0, 12, 6);
		List<Tick> ticks = new ArrayList<Tick>();
		ticks.add(yesterdayTick);
		ticks.add(todayTick);
		MockTimeSeries series = new MockTimeSeries(ticks);
		DirectionalMovementDownIndicator down = new DirectionalMovementDownIndicator(series);
		assertThat(down.getValue(1)).isEqualTo(0d);
	}
	@Test
	public void testZeroDirectionalMovement3()
	{
		MockTick yesterdayTick = new MockTick(0, 0, 6, 6);
		MockTick todayTick = new MockTick(0, 0, 12, 4);
		List<Tick> ticks = new ArrayList<Tick>();
		ticks.add(yesterdayTick);
		ticks.add(todayTick);
		MockTimeSeries series = new MockTimeSeries(ticks);
		DirectionalMovementDownIndicator down = new DirectionalMovementDownIndicator(series);
		assertThat(down.getValue(1)).isEqualTo(0d);
	}
	@Test
	public void testPositiveDirectionalMovement()
	{
		MockTick yesterdayTick = new MockTick(0, 0, 6, 20);
		MockTick todayTick = new MockTick(0, 0, 12, 4);
		List<Tick> ticks = new ArrayList<Tick>();
		ticks.add(yesterdayTick);
		ticks.add(todayTick);
		MockTimeSeries series = new MockTimeSeries(ticks);
		DirectionalMovementDownIndicator down = new DirectionalMovementDownIndicator(series);
		assertThat(down.getValue(1)).isEqualTo(16d);
	}
}