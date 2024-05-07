package cn.yvenxx.system.controller;

import cn.yvenxx.common.entity.TArticle;
import cn.yvenxx.system.service.ITArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class TArticleController {

    @Autowired
    private ITArticleService articleService;

    @GetMapping
    public ResponseEntity<Page<TArticle>> archiveByYearOrCategory(@RequestParam(name = "param",required = false) String searchValue,
                                                         @RequestParam(defaultValue = "1") int currentPage,
                                                         @RequestParam(defaultValue = "10") int pageSize) {
        Page<TArticle> page = new Page<>(currentPage, pageSize);
        if (searchValue!=null){
            QueryWrapper<TArticle> qw = new QueryWrapper<>();
            // 判断searchValue是不是年份
            if (searchValue.matches("\\d{4}")) {
                qw.like("create_time", searchValue);
            }
            else {
                qw.like("category", searchValue);
            }
            return ResponseEntity.ok(articleService.page(page,qw));
        }
        return ResponseEntity.ok(articleService.page(page));
    }
    @GetMapping("/title")
    public ResponseEntity<Page<TArticle>> getArticlesByTitle(@RequestParam(name = "param",required = false) String searchValue,
                                                                  @RequestParam(defaultValue = "1") int currentPage,
                                                                  @RequestParam(defaultValue = "10") int pageSize) {
        Page<TArticle> page = new Page<>(currentPage, pageSize);
        if (searchValue!=null){
            QueryWrapper<TArticle> qw = new QueryWrapper<>();
            qw.like("title", searchValue);
            return ResponseEntity.ok(articleService.page(page,qw));
        }
        return ResponseEntity.ok(articleService.page(page));
    }


    @GetMapping("/{id}")
    public ResponseEntity<TArticle> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TArticle> createArticle(@RequestBody TArticle article) {
        return ResponseEntity.ok(articleService.save(article) ? article : null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TArticle> updateArticle(@PathVariable Long id, @RequestBody TArticle article) {
        article.setId(id);
        return ResponseEntity.ok(articleService.updateById(article) ? article : null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/year")
    public ResponseEntity<List<String>> getYears() {
        return ResponseEntity.ok(articleService.getYears());
    }

    @GetMapping("/category")
    public ResponseEntity<List<String>> getCategories() {
        return ResponseEntity.ok(articleService.getCategories());
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> getTotal() {
        return ResponseEntity.ok(articleService.count());
    }
}