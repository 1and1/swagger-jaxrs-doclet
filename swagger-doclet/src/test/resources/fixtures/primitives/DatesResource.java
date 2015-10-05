package fixtures.primitives;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @priority 9
 */
@Path("/primitives/dates")
@SuppressWarnings("javadoc")
public class DatesResource {

	@GET
	public Date get() {
		return new Date();
	}

	@POST
	public Response create(Date value) {
		return Response.ok().build();
	}

	@GET
	@Path("/localdate")
	public LocalDate getLocalDate() {
		return null;
	}

	@POST
	@Path("/localdate")
	public Response createLocalDate(LocalDate value) {
		return Response.ok().build();
	}

	@GET
	@Path("/localdatetime")
	public LocalDateTime getLocalDateTime() {
		return null;
	}

	@POST
	@Path("/localdatetime")
	public Response createLocalDateTime(LocalDateTime value) {
		return Response.ok().build();
	}

	@GET
	@Path("/zoneddatetime")
	public ZonedDateTime getZonedDateTime() {
		return null;
	}

	@POST
	@Path("/zoneddatetime")
	public Response createZonedDateTime(ZonedDateTime value) {
		return Response.ok().build();
	}

	@GET
	@Path("/offsettime")
	public OffsetTime getOffsetTime() {
		return null;
	}

	@POST
	@Path("/offsettime")
	public Response createOffsetTime(OffsetTime value) {
		return Response.ok().build();
	}

	@GET
	@Path("/offsetdatetime")
	public OffsetDateTime getOffsetDateTime() {
		return null;
	}

	@POST
	@Path("/offsetdatetime")
	public Response createOffsetDateTime(OffsetDateTime value) {
		return Response.ok().build();
	}

	@GET
	@Path("/instant")
	public OffsetDateTime getInstant() {
		return null;
	}

	@POST
	@Path("/instant")
	public Response createInstant(Instant value) {
		return Response.ok().build();
	}

	@GET
	@Path("/duration")
	public Duration getDuration() {
		return null;
	}

	@POST
	@Path("/duration")
	public Response createDuration(Duration value) {
		return Response.ok().build();
	}

	@GET
	@Path("/monthday")
	public MonthDay getMonthDay() {
		return null;
	}

	@POST
	@Path("/monthday")
	public Response createMonthDay(MonthDay value) {
		return Response.ok().build();
	}

	@GET
	@Path("/period")
	public Period getPeriod() {
		return null;
	}

	@POST
	@Path("/period")
	public Response createPeriod(Period value) {
		return Response.ok().build();
	}

	@GET
	@Path("/year")
	public Year getYear() {
		return null;
	}

	@POST
	@Path("/year")
	public Response createYear(Year value) {
		return Response.ok().build();
	}

	@GET
	@Path("/month")
	public Month getMonth() {
		return null;
	}

	@POST
	@Path("/month")
	public Response createMonth(Month value) {
		return Response.ok().build();
	}

	@GET
	@Path("/dayofweek")
	public DayOfWeek getDayOfWeek() {
		return null;
	}

	@POST
	@Path("/dayofweek")
	public Response createDayOfWeek(DayOfWeek value) {
		return Response.ok().build();
	}

	@GET
	@Path("/yearmonth")
	public YearMonth getYearMonth() {
		return null;
	}

	@POST
	@Path("/yearmonth")
	public Response createYearMonth(YearMonth value) {
		return Response.ok().build();
	}

	@GET
	@Path("/zoneid")
	public ZoneId getZoneId() {
		return null;
	}

	@POST
	@Path("/zoneid")
	public Response createZoneId(ZoneId value) {
		return Response.ok().build();
	}

	@GET
	@Path("/zoneoffset")
	public ZoneOffset getZoneOffset() {
		return null;
	}

	@POST
	@Path("/zoneoffset")
	public Response createZoneOffset(ZoneOffset value) {
		return Response.ok().build();
	}
}
