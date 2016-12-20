/*
@license
dhtmlxScheduler v.4.3.1 

This software is covered by GPL license. You also can obtain Commercial or Enterprise license to use it in non-GPL project - please contact sales@dhtmlx.com. Usage without proper license is prohibited.

(c) Dinamenta, UAB.
*/
scheduler.config.limit_start = null, scheduler.config.limit_end = null, scheduler.config.limit_view = !1, scheduler.config.check_limits = !0, scheduler.config.mark_now = !0, scheduler.config.display_marked_timespans = !0, scheduler._temp_limit_scope = function() {
    function e(e, t, a, r, i) {
        var n = scheduler,
            l = [],
            d = {
                _props: "map_to",
                matrix: "y_property"
            };
        for (var s in d) {
            var o = d[s];
            if (n[s])
                for (var _ in n[s]) {
                    var c = n[s][_],
                        u = c[o];
                    e[u] && (l = n._add_timespan_zones(l, scheduler._get_blocked_zones(t[_], e[u], a, r, i)))
                }
        }
        return l = n._add_timespan_zones(l, scheduler._get_blocked_zones(t, "global", a, r, i));

    }
    var t = null,
        a = "dhx_time_block",
        r = "default",
        i = function(e, t, a) {
            return t instanceof Date && a instanceof Date ? (e.start_date = t, e.end_date = a) : (e.days = t, e.zones = a), e
        },
        n = function(e, t, r) {
            var n = "object" == typeof e ? e : {
                days: e
            };
            return n.type = a, n.css = "", t && (r && (n.sections = r), n = i(n, e, t)), n
        };
    scheduler.blockTime = function(e, t, a) {
        var r = n(e, t, a);
        return scheduler.addMarkedTimespan(r)
    }, scheduler.unblockTime = function(e, t, a) {
        t = t || "fullday";
        var r = n(e, t, a);
        return scheduler.deleteMarkedTimespan(r)
    }, scheduler.attachEvent("onBeforeViewChange", function(e, t, a, r) {
        function i(e, t) {
            var a = scheduler.config.limit_start,
                r = scheduler.config.limit_end,
                i = scheduler.date.add(e, 1, t);
            return e.valueOf() > r.valueOf() || i <= a.valueOf()
        }
        return scheduler.config.limit_view && (r = r || t, a = a || e, i(r, a) && t.valueOf() != r.valueOf()) ? (setTimeout(function() {
            var e = i(t, a) ? scheduler.config.limit_start : t;
            scheduler.setCurrentView(i(e, a) ? null : e, a)
        }, 1), !1) : !0
    }), scheduler.checkInMarkedTimespan = function(t, a, i) {
        a = a || r;
        for (var n = !0, l = new Date(t.start_date.valueOf()), d = scheduler.date.add(l, 1, "day"), s = scheduler._marked_timespans; l < t.end_date; l = scheduler.date.date_part(d),
            d = scheduler.date.add(l, 1, "day")) {
            var o = +scheduler.date.date_part(new Date(l)),
                _ = l.getDay(),
                c = e(t, s, _, o, a);
            if (c)
                for (var u = 0; u < c.length; u += 2) {
                    var h = scheduler._get_zone_minutes(l),
                        p = t.end_date > d || t.end_date.getDate() != l.getDate() ? 1440 : scheduler._get_zone_minutes(t.end_date),
                        v = c[u],
                        m = c[u + 1];
                    if (p > v && m > h && (n = "function" == typeof i ? i(t, h, p, v, m) : !1, !n)) break
                }
        }
        return !n
    };
    var l = scheduler.checkLimitViolation = function(e) {
        if (!e) return !0;
        if (!scheduler.config.check_limits) return !0;
        var t = scheduler,
            r = t.config,
            i = [];
        if (e.rec_type)
            for (var n = scheduler.getRecDates(e), l = 0; l < n.length; l++) {
                var d = scheduler._copy_event(e);
                scheduler._lame_copy(d, n[l]), i.push(d)
            } else i = [e];
        for (var s = !0, o = 0; o < i.length; o++) {
            var _ = !0,
                d = i[o];
            d._timed = scheduler.isOneDayEvent(d), _ = r.limit_start && r.limit_end ? d.start_date.valueOf() >= r.limit_start.valueOf() && d.end_date.valueOf() <= r.limit_end.valueOf() : !0, _ && (_ = !scheduler.checkInMarkedTimespan(d, a, function(e, a, r, i, n) {
                var l = !0;
                return n >= a && a >= i && ((1440 == n || n > r) && (l = !1), e._timed && t._drag_id && "new-size" == t._drag_mode ? (e.start_date.setHours(0), e.start_date.setMinutes(n)) : l = !1),
                    (r >= i && n > r || i > a && r > n) && (e._timed && t._drag_id && "new-size" == t._drag_mode ? (e.end_date.setHours(0), e.end_date.setMinutes(i)) : l = !1), l
            })), _ || (_ = t.checkEvent("onLimitViolation") ? t.callEvent("onLimitViolation", [d.id, d]) : _), s = s && _
        }
        return s || (t._drag_id = null, t._drag_mode = null), s
    };
    scheduler._get_blocked_zones = function(e, t, a, r, i) {
            var n = [];
            if (e && e[t])
                for (var l = e[t], d = this._get_relevant_blocked_zones(a, r, l, i), s = 0; s < d.length; s++) n = this._add_timespan_zones(n, d[s].zones);
            return n
        }, scheduler._get_relevant_blocked_zones = function(e, t, a, r) {
            var i = a[t] && a[t][r] ? a[t][r] : a[e] && a[e][r] ? a[e][r] : [];
            return i
        }, scheduler.attachEvent("onMouseDown", function(e) {
            return !(e == a)
        }), scheduler.attachEvent("onBeforeDrag", function(e) {
            return e ? l(scheduler.getEvent(e)) : !0
        }), scheduler.attachEvent("onClick", function(e, t) {
            return l(scheduler.getEvent(e))
        }), scheduler.attachEvent("onBeforeLightbox", function(e) {
            var a = scheduler.getEvent(e);
            return t = [a.start_date, a.end_date], l(a)
        }), scheduler.attachEvent("onEventSave", function(e, t, a) {
            if (!t.start_date || !t.end_date) {
                var r = scheduler.getEvent(e);
                t.start_date = new Date(r.start_date), t.end_date = new Date(r.end_date)
            }
            if (t.rec_type) {
                var i = scheduler._lame_clone(t);
                return scheduler._roll_back_dates(i), l(i)
            }
            return l(t)
        }), scheduler.attachEvent("onEventAdded", function(e) {
            if (!e) return !0;
            var t = scheduler.getEvent(e);
            return !l(t) && scheduler.config.limit_start && scheduler.config.limit_end && (t.start_date < scheduler.config.limit_start && (t.start_date = new Date(scheduler.config.limit_start)), t.start_date.valueOf() >= scheduler.config.limit_end.valueOf() && (t.start_date = this.date.add(scheduler.config.limit_end, -1, "day")),
                t.end_date < scheduler.config.limit_start && (t.end_date = new Date(scheduler.config.limit_start)), t.end_date.valueOf() >= scheduler.config.limit_end.valueOf() && (t.end_date = this.date.add(scheduler.config.limit_end, -1, "day")), t.start_date.valueOf() >= t.end_date.valueOf() && (t.end_date = this.date.add(t.start_date, this.config.event_duration || this.config.time_step, "minute")), t._timed = this.isOneDayEvent(t)), !0
        }), scheduler.attachEvent("onEventChanged", function(e) {
            if (!e) return !0;
            var a = scheduler.getEvent(e);
            if (!l(a)) {
                if (!t) return !1;
                a.start_date = t[0], a.end_date = t[1], a._timed = this.isOneDayEvent(a)
            }
            return !0
        }), scheduler.attachEvent("onBeforeEventChanged", function(e, t, a) {
            return l(e)
        }), scheduler.attachEvent("onBeforeEventCreated", function(e) {
            var t = scheduler.getActionData(e).date,
                a = {
                    _timed: !0,
                    start_date: t,
                    end_date: scheduler.date.add(t, scheduler.config.time_step, "minute")
                };
            return l(a)
        }), scheduler.attachEvent("onViewChange", function() {
            scheduler._mark_now()
        }), scheduler.attachEvent("onSchedulerResize", function() {
            return window.setTimeout(function() {
                scheduler._mark_now()
            }, 1), !0
        }), scheduler.attachEvent("onTemplatesReady", function() {
            scheduler._mark_now_timer = window.setInterval(function() {
                scheduler._is_initialized() && scheduler._mark_now()
            }, 6e4)
        }), scheduler._mark_now = function(e) {
            var t = "dhx_now_time";
            this._els[t] || (this._els[t] = []);
            var a = scheduler._currentDate(),
                r = this.config;
            if (scheduler._remove_mark_now(), !e && r.mark_now && a < this._max_date && a > this._min_date && a.getHours() >= r.first_hour && a.getHours() < r.last_hour) {
                var i = this.locate_holder_day(a);
                this._els[t] = scheduler._append_mark_now(i, a);

            }
        }, scheduler._append_mark_now = function(e, t) {
            var a = "dhx_now_time",
                r = scheduler._get_zone_minutes(t),
                i = {
                    zones: [r, r + 1],
                    css: a,
                    type: a
                };
            if (!this._table_view) {
                if (this._props && this._props[this._mode]) {
                    for (var n = this._props[this._mode], l = n.size || n.options.length, d = e * l, s = (e + 1) * l, o = (this._els.dhx_cal_data[0].childNodes, []), _ = d; s > _; _++) {
                        var c = _;
                        i.days = c;
                        var u = scheduler._render_marked_timespan(i, null, c)[0];
                        o.push(u)
                    }
                    return o
                }
                return i.days = e, scheduler._render_marked_timespan(i, null, e)
            }
            return "month" == this._mode ? (i.days = +scheduler.date.date_part(t),
                scheduler._render_marked_timespan(i, null, null)) : void 0
        }, scheduler._remove_mark_now = function() {
            for (var e = "dhx_now_time", t = this._els[e], a = 0; a < t.length; a++) {
                var r = t[a],
                    i = r.parentNode;
                i && i.removeChild(r)
            }
            this._els[e] = []
        }, scheduler._marked_timespans = {
            global: {}
        }, scheduler._get_zone_minutes = function(e) {
            return 60 * e.getHours() + e.getMinutes()
        }, scheduler._prepare_timespan_options = function(e) {
            var t = [],
                a = [];
            if ("fullweek" == e.days && (e.days = [0, 1, 2, 3, 4, 5, 6]), e.days instanceof Array) {
                for (var i = e.days.slice(), n = 0; n < i.length; n++) {
                    var l = scheduler._lame_clone(e);
                    l.days = i[n], t.push.apply(t, scheduler._prepare_timespan_options(l))
                }
                return t
            }
            if (!e || !(e.start_date && e.end_date && e.end_date > e.start_date || void 0 !== e.days && e.zones)) return t;
            var d = 0,
                s = 1440;
            "fullday" == e.zones && (e.zones = [d, s]), e.zones && e.invert_zones && (e.zones = scheduler.invertZones(e.zones)), e.id = scheduler.uid(), e.css = e.css || "", e.type = e.type || r;
            var o = e.sections;
            if (o) {
                for (var _ in o)
                    if (o.hasOwnProperty(_)) {
                        var c = o[_];
                        c instanceof Array || (c = [c]);
                        for (var n = 0; n < c.length; n++) {
                            var u = scheduler._lame_copy({}, e);
                            u.sections = {}, u.sections[_] = c[n], a.push(u)
                        }
                    }
            } else a.push(e);
            for (var h = 0; h < a.length; h++) {
                var p = a[h],
                    v = p.start_date,
                    m = p.end_date;
                if (v && m)
                    for (var g = scheduler.date.date_part(new Date(v)), b = scheduler.date.add(g, 1, "day"); m > g;) {
                        var u = scheduler._lame_copy({}, p);
                        delete u.start_date, delete u.end_date, u.days = g.valueOf();
                        var y = v > g ? scheduler._get_zone_minutes(v) : d,
                            f = m > b || m.getDate() != g.getDate() ? s : scheduler._get_zone_minutes(m);
                        u.zones = [y, f], t.push(u), g = b, b = scheduler.date.add(b, 1, "day");

                    } else p.days instanceof Date && (p.days = scheduler.date.date_part(p.days).valueOf()), p.zones = e.zones.slice(), t.push(p)
            }
            return t
        }, scheduler._get_dates_by_index = function(e, t, a) {
            var r = [];
            t = scheduler.date.date_part(new Date(t || scheduler._min_date)), a = new Date(a || scheduler._max_date);
            for (var i = t.getDay(), n = e - i >= 0 ? e - i : 7 - t.getDay() + e, l = scheduler.date.add(t, n, "day"); a > l; l = scheduler.date.add(l, 1, "week")) r.push(l);
            return r
        }, scheduler._get_css_classes_by_config = function(e) {
            var t = [];
            return e.type == a && (t.push(a),
                e.css && t.push(a + "_reset")), t.push("dhx_marked_timespan", e.css), t.join(" ")
        }, scheduler._get_block_by_config = function(e) {
            var t = document.createElement("DIV");
            return e.html && ("string" == typeof e.html ? t.innerHTML = e.html : t.appendChild(e.html)), t
        }, scheduler._render_marked_timespan = function(e, t, a) {
            var r = [],
                i = scheduler.config,
                n = this._min_date,
                l = this._max_date,
                d = !1;
            if (!i.display_marked_timespans) return r;
            if (!a && 0 !== a) {
                if (e.days < 7) a = e.days;
                else {
                    var s = new Date(e.days);
                    if (d = +s, !(+l > +s && +s >= +n)) return r;
                    a = s.getDay();

                }
                var o = n.getDay();
                o > a ? a = 7 - (o - a) : a -= o
            }
            var _ = e.zones,
                c = scheduler._get_css_classes_by_config(e);
            if (scheduler._table_view && "month" == scheduler._mode) {
                var u = [],
                    h = [];
                if (t) u.push(t), h.push(a);
                else {
                    h = d ? [d] : scheduler._get_dates_by_index(a);
                    for (var p = 0; p < h.length; p++) u.push(this._scales[h[p]])
                }
                for (var p = 0; p < u.length; p++) {
                    t = u[p], a = h[p];
                    var v = Math.floor((this._correct_shift(a, 1) - n.valueOf()) / (864e5 * this._cols.length)),
                        m = this.locate_holder_day(a, !1) % this._cols.length;
                    if (!this._ignores[m]) {
                        var g = scheduler._get_block_by_config(e),
                            b = Math.max(t.offsetHeight - 1, 0),
                            y = Math.max(t.offsetWidth - 1, 0),
                            f = this._colsS[m],
                            x = this._colsS.heights[v] + (this._colsS.height ? this.xy.month_scale_height + 2 : 2) - 1;

                        g.className = c, g.style.top = x + "px", g.style.lineHeight = g.style.height = b + "px";
                        for (var k = 0; k < _.length; k += 2) {
                            var w = _[p],
                                D = _[p + 1];
                            if (w >= D) return [];
                            var E = g.cloneNode(!0);
                            E.style.left = f + Math.round(w / 1440 * y) + "px", E.style.width = Math.round((D - w) / 1440 * y) + "px", t.appendChild(E), r.push(E)
                        }
                    }
                }
            } else {
                var M = a;
                if (this._ignores[this.locate_holder_day(a, !1)]) return r;
                if (this._props && this._props[this._mode] && e.sections && e.sections[this._mode]) {
                    var S = this._props[this._mode];
                    M = S.order[e.sections[this._mode]];
                    var O = S.order[e.sections[this._mode]];

                    if (S.days > 1) {
                        var N = S.size || S.options.length;
                        M = M * N + O
                    } else M = O, S.size && M > S.position + S.size && (M = 0)
                }
                t = t ? t : scheduler.locate_holder(M);
                for (var p = 0; p < _.length; p += 2) {
                    var w = Math.max(_[p], 60 * i.first_hour),
                        D = Math.min(_[p + 1], 60 * i.last_hour);
                    if (w >= D) {
                        if (p + 2 < _.length) continue;
                        return []
                    }
                    var E = scheduler._get_block_by_config(e);
                    E.className = c;
                    var L = 24 * this.config.hour_size_px + 1,
                        A = 36e5;
                    E.style.top = Math.round((60 * w * 1e3 - this.config.first_hour * A) * this.config.hour_size_px / A) % L + "px", E.style.lineHeight = E.style.height = Math.max(Math.round(60 * (D - w) * 1e3 * this.config.hour_size_px / A) % L, 1) + "px",
                        t.appendChild(E), r.push(E)
                }
            }
            return r
        }, scheduler.markTimespan = function(e) {
            var t = [],
                a = !1;
            this._els.dhx_cal_data || (scheduler.get_elements(), a = !0);
            var r = this._els.dhx_cal_data[0],
                i = scheduler._marked_timespans_ids,
                n = scheduler._marked_timespans_types,
                l = scheduler._marked_timespans;
            scheduler.deleteMarkedTimespan(), scheduler.addMarkedTimespan(e);
            for (var d = new Date(scheduler._min_date), s = 0, o = r.childNodes.length; o > s; s++) {
                var _ = r.childNodes[s];
                _.firstChild && (_.firstChild.className || "").indexOf("dhx_scale_hour") > -1 || (t.push.apply(t, scheduler._on_scale_add_marker(_, d)),
                    d = scheduler.date.add(d, 1, "day"))
            }
            return a && (scheduler._els = []), scheduler._marked_timespans_ids = i, scheduler._marked_timespans_types = n, scheduler._marked_timespans = l, t
        }, scheduler.unmarkTimespan = function(e) {
            if (e)
                for (var t = 0; t < e.length; t++) {
                    var a = e[t];
                    a.parentNode && a.parentNode.removeChild(a)
                }
        }, scheduler._marked_timespans_ids = {}, scheduler.addMarkedTimespan = function(e) {
            var t = scheduler._prepare_timespan_options(e),
                a = "global";
            if (t.length) {
                var r = t[0].id,
                    i = scheduler._marked_timespans,
                    n = scheduler._marked_timespans_ids;

                n[r] || (n[r] = []);
                for (var l = 0; l < t.length; l++) {
                    var d = t[l],
                        s = d.days,
                        o = (d.zones, d.css, d.sections),
                        _ = d.type;
                    if (d.id = r, o) {
                        for (var c in o)
                            if (o.hasOwnProperty(c)) {
                                i[c] || (i[c] = {});
                                var u = o[c],
                                    h = i[c];
                                h[u] || (h[u] = {}), h[u][s] || (h[u][s] = {}), h[u][s][_] || (h[u][s][_] = [], scheduler._marked_timespans_types || (scheduler._marked_timespans_types = {}), scheduler._marked_timespans_types[_] || (scheduler._marked_timespans_types[_] = !0));
                                var p = h[u][s][_];
                                d._array = p, p.push(d), n[r].push(d)
                            }
                    } else {
                        i[a][s] || (i[a][s] = {}), i[a][s][_] || (i[a][s][_] = []),
                            scheduler._marked_timespans_types || (scheduler._marked_timespans_types = {}), scheduler._marked_timespans_types[_] || (scheduler._marked_timespans_types[_] = !0);
                        var p = i[a][s][_];
                        d._array = p, p.push(d), n[r].push(d)
                    }
                }
                return r
            }
        }, scheduler._add_timespan_zones = function(e, t) {
            var a = e.slice();
            if (t = t.slice(), !a.length) return t;
            for (var r = 0; r < a.length; r += 2)
                for (var i = a[r], n = a[r + 1], l = r + 2 == a.length, d = 0; d < t.length; d += 2) {
                    var s = t[d],
                        o = t[d + 1];
                    if (o > n && n >= s || i > s && o >= i) a[r] = Math.min(i, s), a[r + 1] = Math.max(n, o), r -= 2;
                    else {
                        if (!l) continue;

                        var _ = i > s ? 0 : 2;
                        a.splice(r + _, 0, s, o)
                    }
                    t.splice(d--, 2);
                    break
                }
            return a
        }, scheduler._subtract_timespan_zones = function(e, t) {
            for (var a = e.slice(), r = 0; r < a.length; r += 2)
                for (var i = a[r], n = a[r + 1], l = 0; l < t.length; l += 2) {
                    var d = t[l],
                        s = t[l + 1];
                    if (s > i && n > d) {
                        var o = !1;
                        i >= d && s >= n && a.splice(r, 2), d > i && (a.splice(r, 2, i, d), o = !0), n > s && a.splice(o ? r + 2 : r, o ? 0 : 2, s, n), r -= 2;
                        break
                    }
                }
            return a
        }, scheduler.invertZones = function(e) {
            return scheduler._subtract_timespan_zones([0, 1440], e.slice())
        }, scheduler._delete_marked_timespan_by_id = function(e) {
            var t = scheduler._marked_timespans_ids[e];
            if (t)
                for (var a = 0; a < t.length; a++)
                    for (var r = t[a], i = r._array, n = 0; n < i.length; n++)
                        if (i[n] == r) {
                            i.splice(n, 1);
                            break
                        }
        }, scheduler._delete_marked_timespan_by_config = function(e) {
            var t = scheduler._marked_timespans,
                a = e.sections,
                i = e.days,
                n = e.type || r,
                l = [];
            if (a) {
                for (var d in a)
                    if (a.hasOwnProperty(d) && t[d]) {
                        var s = a[d];
                        t[d][s] && t[d][s][i] && t[d][s][i][n] && (l = t[d][s][i][n])
                    }
            } else t.global[i] && t.global[i][n] && (l = t.global[i][n]);
            for (var o = 0; o < l.length; o++) {
                var _ = l[o],
                    c = scheduler._subtract_timespan_zones(_.zones, e.zones);

                if (c.length) _.zones = c;
                else {
                    l.splice(o, 1), o--;
                    for (var u = scheduler._marked_timespans_ids[_.id], h = 0; h < u.length; h++)
                        if (u[h] == _) {
                            u.splice(h, 1);
                            break
                        }
                }
            }
            for (var o in scheduler._marked_timespans.timeline)
                for (var p in scheduler._marked_timespans.timeline[o])
                    for (var h in scheduler._marked_timespans.timeline[o][p]) h === n && delete scheduler._marked_timespans.timeline[o][p][h]
        }, scheduler.deleteMarkedTimespan = function(e) {
            if (arguments.length || (scheduler._marked_timespans = {
                        global: {}
                    }, scheduler._marked_timespans_ids = {},
                    scheduler._marked_timespans_types = {}), "object" != typeof e) scheduler._delete_marked_timespan_by_id(e);
            else {
                e.start_date && e.end_date || (e.days || (e.days = "fullweek"), e.zones || (e.zones = "fullday"));
                var t = [];
                if (e.type) t.push(e.type);
                else
                    for (var a in scheduler._marked_timespans_types) t.push(a);
                for (var r = scheduler._prepare_timespan_options(e), i = 0; i < r.length; i++)
                    for (var n = r[i], l = 0; l < t.length; l++) {
                        var d = scheduler._lame_clone(n);
                        d.type = t[l], scheduler._delete_marked_timespan_by_config(d)
                    }
            }
        }, scheduler._get_types_to_render = function(e, t) {
            var a = e ? e : {};
            for (var r in t || {}) t.hasOwnProperty(r) && (a[r] = t[r]);
            return a
        }, scheduler._get_configs_to_render = function(e) {
            var t = [];
            for (var a in e) e.hasOwnProperty(a) && t.push.apply(t, e[a]);
            return t
        }, scheduler._on_scale_add_marker = function(e, t) {
            if (!scheduler._table_view || "month" == scheduler._mode) {
                var a = t.getDay(),
                    r = t.valueOf(),
                    i = this._mode,
                    n = scheduler._marked_timespans,
                    l = [],
                    d = [];
                if (this._props && this._props[i]) {
                    var s = this._props[i],
                        o = s.options,
                        _ = scheduler._get_unit_index(s, t),
                        c = o[_];
                    if (s.days > 1) {
                        var u = 864e5,
                            h = Math.floor((t - scheduler._min_date) / u);

                        t = scheduler.date.add(scheduler._min_date, Math.floor(h / o.length), "day"), t = scheduler.date.date_part(t)
                    } else t = scheduler.date.date_part(new Date(this._date));
                    if (a = t.getDay(), r = t.valueOf(), n[i] && n[i][c.key]) {
                        var p = n[i][c.key],
                            v = scheduler._get_types_to_render(p[a], p[r]);
                        l.push.apply(l, scheduler._get_configs_to_render(v))
                    }
                }
                var m = n.global,
                    g = m[r] || m[a];
                l.push.apply(l, scheduler._get_configs_to_render(g));
                for (var b = 0; b < l.length; b++) d.push.apply(d, scheduler._render_marked_timespan(l[b], e, t));
                return d
            }
        }, scheduler.attachEvent("onScaleAdd", scheduler._on_scale_add_marker),
        scheduler.dblclick_dhx_marked_timespan = function(e, t) {
            scheduler.config.dblclick_create || scheduler.callEvent("onScaleDblClick", [scheduler.getActionData(e).date, t, e]), scheduler.addEventNow(scheduler.getActionData(e).date, null, e)
        }
}, scheduler._temp_limit_scope();
//# sourceMappingURL=../sources/ext/dhtmlxscheduler_limit.js.map