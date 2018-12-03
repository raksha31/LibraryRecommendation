/**
 *
 */
package zenjob.config;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
//@Configuration
//@ConfigurationProperties(prefix = "zenjob.constants")
@NoArgsConstructor
public class CategoryMapper{
	private  Map<String, Integer> categories = new HashMap<>();
	public Map<String, Integer> getCategoryMap() {
		categories.put("Arts & Photography", 0);
		categories.put("Biographies & Memoirs", 1);
		categories.put("Business & Money", 2);
		categories.put("Calendars", 3);
		categories.put("Children's Books", 4);
		categories.put("Comics & Graphic Novels", 5);
		categories.put("Computers & Technology",6);
		categories.put("Cookbooks, Food & Wine", 7);
		categories.put("Crafts, Hobbies & Home", 8);
		categories.put("Christian Books & Bibles", 9);
		categories.put("Engineering & Transportation", 10);
		categories.put("Health, Fitness & Dieting", 11);
		categories.put("History", 12);
		categories.put("Humor & Entertainment", 13);
		categories.put("Law", 14);
		categories.put("Literature & Fiction", 15);
		categories.put("Medical Books", 16);
		categories.put("Mystery, Thriller & Suspense", 17);
		categories.put("Parenting & Relationships", 18);
		categories.put("Politics & Social Sciences", 19);
		categories.put("Reference", 20);
		categories.put("Religion & Spirituality", 21);
		categories.put("Romance", 22);
		categories.put("Science & Math", 23);
		categories.put("Science Fiction & Fantasy", 24);
		categories.put("Self-Help", 25);
		categories.put("Sports & Outdoors", 26);
		categories.put("Teen & Young Adult", 27);
		categories.put("Test Preparation", 28);
		categories.put("Travel", 29);

 return categories;
	}
}