package fr.maed.website.kwizzy.esorm.queries;

import org.json.JSONObject;

/**
 * Created by alexis on 25/10/17.
 * French author.
 */
public class Range<T extends Number> extends Query
{
    public Range(String field, T from, T to)
    {
        obj.getJSONObject("range").put(field, new JSONObject().put("gte", from).put("lte", to));
    }

    public Range(String field, T value, Operator o)
    {
        obj.getJSONObject("range").put(field, new JSONObject().put(o.operator, value));
    }

    @Override
    void init()
    {
        obj.put("range", new JSONObject());
    }

    public enum Operator {
        GREATER_THAN("gt"),
        LESSER_THAN("lt");

        private String operator;

        Operator(String operator)
        {
            this.operator = operator;
        }
    }
}
