-- Query all moon materials that need jita price updated, i.e you need to look at those olrder than  month
select tmn.typeid, tmn.typename as "Mineral", max(ml.price) as "Jita Price", max(ml.lastupdated) as "Last Updated"
from invtype tmn
inner join invtypematerial tm on tm.materialtypeid = tmn.typeid
inner join moonmaterial mm on mm.oretypeid = tm.typeid
left join marketlog ml on
  ml.typeid = tm.materialtypeid
  and ml.bid = true
  and ml.stationid = 60003760 -- "Jita IV - Moon 4 - Caldari Navy Assembly Plant"
group by tmn.typename, tmn.typeid
order by 4

-- Calculate Price of Moon material based on their minerals jita price
delete from moonoreprice;
WITH jitaprice AS (
        SELECT typeid, max(price) as price
        FROM marketlog
        WHERE bid = true
          and stationid = 60003760 -- "Jita IV - Moon 4 - Caldari Navy Assembly Plant"
        GROUP BY typeid
     )
insert into moonoreprice (oretypeid, price, lastupdated)
	select ore.typeid as "oretypeid", round(sum(mt.quantity * jp.price / ot.portionsize)::DECIMAL, 2), current_timestamp
	from invtype ore
	inner join invtypematerial mt on mt.typeid = ore.typeid
	inner join invtype mn on mn.typeid = mt.materialtypeid
	inner join jitaprice jp on jp.typeid = mt.materialtypeid
	inner join invtype ot on ot.typeid = ore.typeid
	where mt.typeid in (select distinct oretypeid from moonmaterial)
	group by ore.typename, ore.typeid


-- calculate moon mining profitability PER WEEK
-- Based on Moon ore weekly volume: 3000000
select mn.itemname, round(sum(3000000 * mm.quantity / mt.volume * mop.price)::DECIMAL, 2) as "Max Profit"
from invname mn
inner join moonmaterial mm on mm.moonid = mn.itemid
inner join moonoreprice mop on mop.oretypeid = mm.oretypeid
inner join invtype mt on mt.typeid = mm.oretypeid
group by mn.itemname
order by 2 desc


-- Moon Profitability Insights
-- Based on Moon ore weekly volume: 3000000
select mn.itemname, mt.typename, mm.quantity, mt.volume, mop.price, round((3000000 * mm.quantity / mt.volume * mop.price)::DECIMAL, 2)
from invname mn
inner join moonmaterial mm on mm.moonid = mn.itemid
inner join moonoreprice mop on mop.oretypeid = mm.oretypeid
inner join invtype mt on mt.typeid = mm.oretypeid
where mn.itemname = 'M-MD3B III - Moon 2'
order by 1


-- Insights of a single unit of moon material components and their portion amount
WITH jitaprice AS (
        SELECT typeid, max(price) as price
        FROM marketlog
        WHERE bid = true
          and stationid = 60003760 -- "Jita IV - Moon 4 - Caldari Navy Assembly Plant"
        GROUP BY typeid
     )
select it.typename, itm.quantity, imt.typename, jp.price, round((itm.quantity * jp.price / it.portionsize)::DECIMAL, 2) as "amount"
from invtypematerial itm
inner join invtype it on it.typeid = itm.typeid
inner join invtype imt on imt.typeid = itm.materialtypeid
inner join jitaprice jp on jp.typeid = itm.materialtypeid
where it.typename = 'Loparite'
